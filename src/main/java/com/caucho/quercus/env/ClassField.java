/*
 * Copyright (c) 1998-2012 Caucho Technology -- all rights reserved
 *
 * This file is part of Resin(R) Open Source
 *
 * Each copy or derived work must preserve the copyright notice and this
 * notice unmodified.
 *
 * Resin Open Source is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Resin Open Source is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, or any warranty
 * of NON-INFRINGEMENT.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Resin Open Source; if not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330
 *   Boston, MA 02111-1307  USA
 *
 * @author Nam Nguyen
 */

package com.caucho.quercus.env;

import com.caucho.quercus.expr.Expr;

public class ClassField
{
  private StringValue _name;
  private Expr _initValue;
  private FieldVisibility _visibility = FieldVisibility.PUBLIC;
  
  public ClassField(StringValue name,
                    Expr initValue,
                    FieldVisibility visibility)
  {
    _name = name;
    _initValue = initValue;
    _visibility = visibility;
  }
  
  public ClassField(StringValue name, Expr initValue)
  {
    this(name, initValue, FieldVisibility.PUBLIC);
  }
  
  public StringValue getName()
  {
    return _name;
  }
  
  public Expr getInitValue()
  {
    return _initValue;
  }
  
  public void setInitValue(Expr initValue)
  {
    _initValue = initValue;
  }
  
  public FieldVisibility getVisibility()
  {
    return _visibility;
  }
  
  public boolean isPublic()
  {
    return _visibility == FieldVisibility.PUBLIC;
  }
  
  public boolean isProtected()
  {
    return _visibility == FieldVisibility.PROTECTED;
  }
  
  public boolean isPrivate()
  {
    return _visibility == FieldVisibility.PRIVATE;
  }
}
