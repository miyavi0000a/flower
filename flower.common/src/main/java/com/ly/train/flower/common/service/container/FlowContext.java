/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
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
package com.ly.train.flower.common.service.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlowContext {

  private static Map<String, ServiceContext> flowContext =
      new ConcurrentHashMap<String, ServiceContext>();

  public static void putServiceContext(String uuid, ServiceContext serviceContext) {
    flowContext.put(uuid, serviceContext);
  }

  public static ServiceContext getServiceContext(String uuid) {
    return flowContext.get(uuid);
  }

  public static void removeServiceContext(String uuid) {
    flowContext.remove(uuid);
  }
}
