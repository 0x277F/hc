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

import java.nio.file.Path;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Base type for a configuration registry.
 */
public interface Configuration {

    /**
     * Get typedefs declared inside the config file. This will not capture typedefs in
     * larger namespaces.
     *
     * @return a set
     */
    @Nonnull
    Set<TypeTransformer> getTypedefs();

    /**
     * Attempt to fetch the class descriptor for the type specified by a typedef in this namespace.
     * Unlike {@link #getTypedefs()}, this will capture typedefs in larger namespaces.
     *
     * @param name the typedef
     * @return a class descriptor, or null if none is found
     */
    @Nullable
    Class<?> getTypedef(@Nonnull String name);

    /**
     * Retrieve a path to the file where this configuration is stored.
     */
    @Nonnull
    Path getPath();

    /**
     * Get a value from the configuration. The fully qualified path to the value is required
     * unless there are no entries with the same name in the same file.
     *
     * @param type the class descriptor of the data type
     * @param path the path to the value
     * @param <T> the type of data the value is
     * @return the value, or null if it does not exist
     */
    @Nullable
    <T> T get(@Nonnull Class<T> type, @Nonnull String path);

    /**
     * Set a value in the configuration. The fully qualified path to the value is required
     * unless there are no entries with the same name in the same file.
     *
     * @param type the class descriptor of the data type
     * @param path the path to the value
     * @param value the value to set
     * @param <T> the type of data that the value is
     */
    <T> void set(@Nonnull Class<T> type, @Nonnull String path, @Nonnull T value);
}
