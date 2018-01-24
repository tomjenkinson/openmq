/*
 * Copyright (c) 2000, 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.messaging.visualvm.dataview;

import com.sun.messaging.visualvm.datasource.ClusteredBrokerDataSource;
import com.sun.tools.visualvm.core.ui.DataSourceView;
import com.sun.tools.visualvm.core.ui.DataSourceViewProvider;
import com.sun.tools.visualvm.core.ui.DataSourceViewsManager;

public class ClusteredBrokerViewProvider extends DataSourceViewProvider<ClusteredBrokerDataSource> {

    private static DataSourceViewProvider<ClusteredBrokerDataSource> instance = new ClusteredBrokerViewProvider();

    @Override
    public boolean supportsViewFor(ClusteredBrokerDataSource lds) {
        return (true);
    }
    
    @Override
    protected DataSourceView createView(ClusteredBrokerDataSource lds) {
        return new ClusteredBrokerView(lds);
    }

    public static void initialize() {
        DataSourceViewsManager.sharedInstance().addViewProvider(instance, ClusteredBrokerDataSource.class);
    }

    public static void unregister() {
        DataSourceViewsManager.sharedInstance().removeViewProvider(instance);
    }
}
