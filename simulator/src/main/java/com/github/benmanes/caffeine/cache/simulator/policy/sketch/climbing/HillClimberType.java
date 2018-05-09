/*
 * Copyright 2016 Ben Manes. All Rights Reserved.
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
 */
package com.github.benmanes.caffeine.cache.simulator.policy.sketch.climbing;

import static java.util.Objects.requireNonNull;

import java.util.function.Function;

import com.typesafe.config.Config;

/**
 * The hill climbers.
 *
 * @author ben.manes@gmail.com (Ben Manes)
 */
@SuppressWarnings("ImmutableEnumChecker")
enum HillClimberType {
  SIMPLE(SimpleClimber::new),
  SIMULATED_ANNEALING(SimulatedAnnealingClimber::new),
  HINTED(HintedClimber::new),
  FEATURES(ExtractFeaturesClimber::new),
  ML(MLClimber::new),
  MINISIM(MiniSimClimber::new);
	

  private final Function<Config, HillClimber> factory;

  HillClimberType(Function<Config, HillClimber> factory) {
    this.factory = requireNonNull(factory);
  }

  public HillClimber create(Config config) {
    return factory.apply(config);
  }
}
