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
/**
 * 
 */
package com.ly.train.flower.registry;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.ly.train.flower.logging.Logger;
import com.ly.train.flower.logging.LoggerFactory;

/**
 * @author leeyazhou
 *
 */
public abstract class AbstractRegistry implements Registry {
  protected final Logger logger = LoggerFactory.getLogger(getClass());
  protected ConcurrentMap<String, ServiceInfo> serviceInfoCache = new ConcurrentHashMap<>();

  @Override
  public boolean register(ServiceInfo serviceInfo) {
    serviceInfoCache.putIfAbsent(serviceInfo.getClassName(), serviceInfo);
    return doRegister(serviceInfo);
  }

  @Override
  public List<ServiceInfo> getProvider(ServiceInfo serviceInfo) {
    return doGetProvider(serviceInfo);
  }

  public abstract boolean doRegister(ServiceInfo serviceInfo);


  public abstract List<ServiceInfo> doGetProvider(ServiceInfo serviceInfo);
}
