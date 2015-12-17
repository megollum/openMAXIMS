//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class FollowUPIn extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public FollowUPIn()
	{
		super();
	}
	public FollowUPIn(int id)
	{
		super(id, "", true);
	}
	public FollowUPIn(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public FollowUPIn(int id, String text, boolean active, FollowUPIn parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public FollowUPIn(int id, String text, boolean active, FollowUPIn parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public FollowUPIn(int id, String text, boolean active, FollowUPIn parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static FollowUPIn buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new FollowUPIn(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (FollowUPIn)super.getParentInstance();
	}
	public FollowUPIn getParent()
	{
		return (FollowUPIn)super.getParentInstance();
	}
	public void setParent(FollowUPIn parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		FollowUPIn[] typedChildren = new FollowUPIn[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (FollowUPIn)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof FollowUPIn)
		{
			super.addChild((FollowUPIn)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof FollowUPIn)
		{
			super.removeChild((FollowUPIn)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		FollowUPInCollection result = new FollowUPInCollection();
		result.add(ONE);
		result.add(TWO);
		result.add(THREE);
		result.add(FOUR);
		result.add(FIVE);
		result.add(SIX);
		result.add(SEVEN);
		result.add(EIGHT);
		result.add(NINE);
		result.add(TEN);
		result.add(ELEVEN);
		result.add(TWELVE);
		return result;
	}
	public static FollowUPIn[] getNegativeInstances()
	{
		FollowUPIn[] instances = new FollowUPIn[12];
		instances[0] = ONE;
		instances[1] = TWO;
		instances[2] = THREE;
		instances[3] = FOUR;
		instances[4] = FIVE;
		instances[5] = SIX;
		instances[6] = SEVEN;
		instances[7] = EIGHT;
		instances[8] = NINE;
		instances[9] = TEN;
		instances[10] = ELEVEN;
		instances[11] = TWELVE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[12];
		negativeInstances[0] = "ONE";
		negativeInstances[1] = "TWO";
		negativeInstances[2] = "THREE";
		negativeInstances[3] = "FOUR";
		negativeInstances[4] = "FIVE";
		negativeInstances[5] = "SIX";
		negativeInstances[6] = "SEVEN";
		negativeInstances[7] = "EIGHT";
		negativeInstances[8] = "NINE";
		negativeInstances[9] = "TEN";
		negativeInstances[10] = "ELEVEN";
		negativeInstances[11] = "TWELVE";
		return negativeInstances;
	}
	public static FollowUPIn getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static FollowUPIn getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		FollowUPIn[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1231142;
	public static final FollowUPIn ONE = new FollowUPIn(-2742, "1", true, null, null, Color.Default);
	public static final FollowUPIn TWO = new FollowUPIn(-2743, "2", true, null, null, Color.Default);
	public static final FollowUPIn THREE = new FollowUPIn(-2744, "3", true, null, null, Color.Default);
	public static final FollowUPIn FOUR = new FollowUPIn(-2745, "4", true, null, null, Color.Default);
	public static final FollowUPIn FIVE = new FollowUPIn(-2746, "5", true, null, null, Color.Default);
	public static final FollowUPIn SIX = new FollowUPIn(-2747, "6", true, null, null, Color.Default);
	public static final FollowUPIn SEVEN = new FollowUPIn(-2748, "7", true, null, null, Color.Default);
	public static final FollowUPIn EIGHT = new FollowUPIn(-2749, "8", true, null, null, Color.Default);
	public static final FollowUPIn NINE = new FollowUPIn(-2750, "9", true, null, null, Color.Default);
	public static final FollowUPIn TEN = new FollowUPIn(-2751, "10", true, null, null, Color.Default);
	public static final FollowUPIn ELEVEN = new FollowUPIn(-2752, "11", true, null, null, Color.Default);
	public static final FollowUPIn TWELVE = new FollowUPIn(-2753, "12", true, null, null, Color.Default);
}