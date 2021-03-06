/***************************************************************************
 * Copyright (C) 2018 iObserve Project (https://www.iobserve-devops.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 ***************************************************************************/
package org.iobserve.selenium.common;

import java.util.Random;

/**
 * @author Reiner Jung
 *
 */
public final class RandomGenerator {

    private static Random random = new Random();

    private RandomGenerator() {
        // factory, therefore private
    }

    /**
     * Generate random number between {@link lower} and {@link upper}.
     *
     * @param lower
     *            lower boundary
     * @param upper
     *            upper boundary
     * @return random number
     */
    public static int getRandomNumber(final int lower, final int upper) {
        final double value = RandomGenerator.random.nextDouble() * (upper - lower);
        return (int) (Math.round(value) + lower);
    }
}
