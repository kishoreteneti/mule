/*
 * $Id: IBeansHolderConfigBuilderTestCase.java 302 2010-02-17 07:57:47Z ross $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.ibeans.annotations;

import org.mule.module.ibeans.config.IBeanHolder;
import org.mule.module.ibeans.config.IBeansLoader;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class IBeansHolderConfigBuilderTestCase extends AbstractIBeansTestCase
{
    @Override
    protected void doTearDown() throws Exception
    {
        System.getProperties().remove(IBeansLoader.SCAN_PACKAGES_PROPERTY);
    }

    @Test
    public void testConfigBuilder() throws Exception
    {
        Collection<IBeanHolder> col = muleContext.getRegistry().lookupObjects(IBeanHolder.class);
        //Ensure IBeanHolder is comparable
        Set<IBeanHolder> beans = new TreeSet<IBeanHolder>(col);

        assertEquals(7, beans.size());
        String[] ids = new String[7];
        int i = 0;
        for (Iterator<IBeanHolder> iterator = beans.iterator(); iterator.hasNext(); i++)
        {
            IBeanHolder iBeanHolder = iterator.next();
            ids[i] = iBeanHolder.getId();
        }

        assertEquals("errorfilter", ids[0]);
        assertEquals("hostip", ids[1]);
        assertEquals("search", ids[2]);
        assertEquals("testexception", ids[3]);
        assertEquals("testimplicitpropertiesinfactory", ids[4]);
        assertEquals("testparamsfactory", ids[5]);
        assertEquals("testuri", ids[6]);
    }
}
