/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.uri;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URI;

import net.kuujo.copycat.registry.Registry;

/**
 * URI authority injector annotation.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
@UriInjectable(UriAuthority.Parser.class)
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UriAuthority {

  /**
   * URI authority parser.
   *
   * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
   */
  public static class Parser implements UriParser<UriAuthority, String> {
    @Override
    public String parse(URI uri, UriAuthority annotation, Registry registry, Class<String> type) {
      return uri.getAuthority();
    }
  }

}
