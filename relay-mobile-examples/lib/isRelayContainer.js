/**
 * Copyright 2013-2015, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 *
 * @providesModule isRelayContainer
 * 
 * @typechecks
 */

'use strict';

function isRelayContainer(component) {
  return !!(component && component.getFragmentNames && component.getFragment && component.hasFragment);
}

module.exports = isRelayContainer;