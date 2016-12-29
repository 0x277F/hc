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

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lc.hex.hc.api.exception.InvalidConfigurationException;

/**
 * Interface for types which participate in the reading and writing of config values.
 */
public interface ConfigProcessor {

    /**
     * Retrieve the config object backing this processor. If it has not been initialized
     * yet, null is returned.
     */
    @Nullable
    Configuration getConfig();

    /**
     * Load the given config's values into this processor and parse them. May throw an
     * {@link InvalidConfigurationException} if there are values in the config which may
     * prevent it from being serialized.
     *
     * @param config the config to load
     */
    void accept(@Nonnull Configuration config) throws InvalidConfigurationException;

    /**
     * Save the config to the default path which it specifies. May throw an {@link IOException}
     * if an I/O error occurs while writing.
     *
     * @return true if writing succeeded, false otherwise (or if the config is uninitialized).
     */
    default boolean commit() throws IOException {
        if (this.getConfig() != null) {
            return this.commit(this.getConfig().getPath());
        }
        return false;
    }

    /**
     * Save the config to the given path. May throw an {@link IOException} if an I/O error
     * occurs while writing.
     *
     * @return true if writing succeeded, false otherwise (or if the config is uninitialized).
     */
    boolean commit(@Nonnull Path path) throws IOException;

    /**
     * Loads a config from file and performs preprocessing. Parsing will <strong>not</strong>
     * occur until {@link #load()} is called. May throw an IOException if there is an error
     * reading the file. Lines which cannot be preprocessed are ignored.
     *
     * @param path the path from which to load the file
     */
    void accept(@Nonnull Path path) throws IOException;

    /**
     * Parses a configuration that was already preprocessed and stored in this processor's
     * buffer by a call to {@link #accept(Path)}. May throw an {@link InvalidConfigurationException}
     * if there is a syntax error parsing the config.
     *
     * @return a new {@link Configuration} object which will now be returned by {@link #getConfig()}
     */
    @Nonnull
    Configuration load() throws InvalidConfigurationException;
}
