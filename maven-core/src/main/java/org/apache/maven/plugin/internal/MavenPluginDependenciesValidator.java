/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.plugin.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.descriptor.MojoDescriptor;

/**
 * Service responsible for validating plugin dependencies.
 *
 * @since 3.9.2
 */
interface MavenPluginDependenciesValidator {

    /**
     * The collection of "G:A" combinations that do NOT belong to Maven Core, hence, should be excluded from
     * "expected in provided scope" type of checks.
     *
     * @since 3.9.3
     */
    Collection<String> EXPECTED_PROVIDED_SCOPE_EXCLUSIONS_GA = Collections.unmodifiableCollection(Arrays.asList(
            "org.apache.maven:maven-archiver", "org.apache.maven:maven-jxr", "org.apache.maven:plexus-utils"));

    /**
     * Checks mojo dependency issues.
     */
    void validate(MavenSession mavenSession, MojoDescriptor mojoDescriptor);
}