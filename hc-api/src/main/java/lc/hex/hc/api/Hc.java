/*
 * Copyright 2016 Hex <hex@hex.lc>
 * and other copyright owners as documented in the project's IP log.
 *
 * Licensed under the Apache License, Version 2.0 (the "License&quot￼;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lc.hex.hc.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates interface types which hold config information.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Hc {
    /**
     * Specify the file (with extension) in which config data is to be stored
     */
    String file() default "config.hc";

    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.TYPE)
    @interface Typedefs {
        Typedef[] value();
    }

    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.TYPE)
    @Repeatable(Typedefs.class)
    @interface Typedef {
        /**
         * Two-element array with the original value being 1, typedef'd value being 2.
         */
        String[] value();
    }

    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.METHOD)
    @interface Qualified {
        /**
         * Specify the name for a specific data field. If this isn't present on a method, the
         * method name will be used instead.
         */
        String value();
    }
}
