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

package com.ververica.statefun.sdk;

/** Provides instances of {@link StatefulFunction}s for a given {@link FunctionType}. */
public interface StatefulFunctionProvider {

  /**
   * Creates a {@link StatefulFunction} instance for the given {@link FunctionType},
   *
   * @param type the type of function to create an instance for.
   * @return an instance of a function for the given type.
   */
  StatefulFunction functionOfType(FunctionType type);
}
