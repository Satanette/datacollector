/**
 * Copyright 2017 StreamSets Inc.
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
package com.streamsets.datacollector.restapi.configuration;

import com.streamsets.datacollector.stagelibrary.StageLibraryTask;

import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

public class StageLibraryInjector implements Factory<StageLibraryTask> {
  public static final String STAGE_LIBRARY = "stage-library";

  private StageLibraryTask library;

  @Inject
  public StageLibraryInjector(HttpServletRequest request) {
    library = (StageLibraryTask) request.getServletContext().getAttribute(STAGE_LIBRARY);
  }

  @Override
  public StageLibraryTask provide() {
    return library;
  }

  @Override
  public void dispose(StageLibraryTask library) {
  }

}
