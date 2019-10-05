/*
 * Copyright 2019 Ververica GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.statefun.docs.io.custom.flink;

import com.ververica.statefun.docs.io.custom.MyIngressSpec;
import com.ververica.statefun.docs.io.custom.flink.source.MySourceFunction;
import com.ververica.statefun.flink.io.spi.SourceProvider;
import com.ververica.statefun.sdk.io.IngressSpec;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class MySourceProvider implements SourceProvider {

  @Override
  public <T> SourceFunction<T> forSpec(IngressSpec<T> ingressSpec) {
    MyIngressSpec<T> spec = asMyIngressSpec(ingressSpec);
    MySourceFunction source = new MySourceFunction();

    // configure the source based on the provided spec
    return source;
  }

  private static <T> MyIngressSpec<T> asMyIngressSpec(IngressSpec<T> ingressSpec) {
    if (ingressSpec == null) {
      throw new NullPointerException("Unable to translate a NULL spec");
    }

    if (ingressSpec instanceof MyIngressSpec) {
      return (MyIngressSpec<T>) ingressSpec;
    }

    throw new IllegalArgumentException(String.format("Wrong type %s", ingressSpec.type()));
  }
}
