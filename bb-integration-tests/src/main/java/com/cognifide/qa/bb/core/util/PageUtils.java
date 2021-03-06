/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
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
 * #L%
 */
package com.cognifide.qa.bb.core.util;

public final class PageUtils {

  private static final String PAGE_NAME = "/page.html";

  private PageUtils() {
  }

  /**
   * Builds a path to core page based on given type package name
   *
   * @param type core class
   * @return URL to the test page
   */
  public static String buildTestPageUrl(final Class<?> type) {
    return System.getProperty("bobcat.tests.target", "http://localhost:4000/bobcat/tests/")
        + pathFrom(type) + PAGE_NAME;
  }

  private static String pathFrom(final Class<?> type) {
    return type.getPackage().getName().replace('.', '/');
  }
}
