/*
 * jPOS Project [http://jpos.org]
 * Copyright (C) 2000-2011 Alejandro P. Revilla
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpos.ee.pm.vaadin.converters;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Field;
import org.jpos.ee.pm.converter.ConverterException;
import org.jpos.ee.pm.core.EntityInstanceWrapper;
import org.jpos.ee.pm.core.PMContext;

/**
 *
 * @author jpaoletti
 */
public class EditBooleanConverter extends VaadinConverter {

    @Override
    public Object build(PMContext ctx) throws ConverterException {
        return ctx.get(PM_FIELD_VALUE);
    }

    @Override
    public Object visualize(PMContext ctx) throws ConverterException {
        Field f = new CheckBox();
        Boolean p = (Boolean) ctx.get(PM_FIELD_VALUE);
        boolean withnull = Boolean.parseBoolean(getConfig("with-null", "false")); //TO-DO
        if (p == null) {
            f.setValue(false);
        } else {
            f.setValue(p);
        }
        return f;
    }
}
