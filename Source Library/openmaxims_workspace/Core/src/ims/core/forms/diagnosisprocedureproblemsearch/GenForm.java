//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.diagnosisprocedureproblemsearch;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	public static class grdSelectedItemsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdSelectedItemsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolItemsReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolItemsReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolItemsOpened()
		{
			super.row.showOpened(0);
		}
		public String getcolItems()
		{
			return (String)super.row.get(0);
		}
		public void setcolItems(String value)
		{
			super.row.set(0, value);
		}
		public void setCellcolItemsTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public java.lang.Object getValue()
		{
			return super.row.getValue();
		}
		public void setValue(java.lang.Object value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdSelectedItemsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdSelectedItemsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdSelectedItemsRow get(int index)
		{
			return new grdSelectedItemsRow(super.collection.get(index));
		}
		public grdSelectedItemsRow newRow()
		{
			return new grdSelectedItemsRow(super.collection.newRow());
		}
		public grdSelectedItemsRow newRow(boolean autoSelect)
		{
			return new grdSelectedItemsRow(super.collection.newRow(autoSelect));
		}
		public grdSelectedItemsRow newRowAt(int index)
		{
			return new grdSelectedItemsRow(super.collection.newRowAt(index));
		}
		public grdSelectedItemsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdSelectedItemsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdSelectedItemsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void setcolItemsCaption(String value)
		{
			this.grid.setColumnCaption(0, value);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public java.lang.Object[] getValues()
		{
			java.lang.Object[] listOfValues = new java.lang.Object[this.getRows().size()];
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues[x] = this.getRows().get(x).getValue();
			}
			return listOfValues;
		}
		public java.lang.Object getValue()
		{
			return super.grid.getValue();
		}
		public void setValue(java.lang.Object value)
		{
			super.grid.setValue(value);
		}
		public grdSelectedItemsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdSelectedItemsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdSelectedItemsRowCollection getRows()
		{
			return new grdSelectedItemsRowCollection(super.grid.getRows());
		}
		public grdSelectedItemsRow getRowByValue(java.lang.Object value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdSelectedItemsRow(row);
		}
		public void setcolItemsHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolItemsHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
	}
	public static class grdItemsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdItemsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolItemsReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolItemsReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolItemsOpened()
		{
			super.row.showOpened(0);
		}
		public String getcolItems()
		{
			return (String)super.row.get(0);
		}
		public void setcolItems(String value)
		{
			super.row.set(0, value);
		}
		public void setCellcolItemsTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setColumnSelectReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean isColumnSelectReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showColumnSelectOpened()
		{
			super.row.showOpened(1);
		}
		public boolean getColumnSelect()
		{
			return ((Boolean)super.row.get(1)).booleanValue();
		}
		public void setColumnSelect(boolean value)
		{
			super.row.set(1, new Boolean(value));
		}
		public void setCellColumnSelectTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public java.lang.Object getValue()
		{
			return super.row.getValue();
		}
		public void setValue(java.lang.Object value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdItemsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdItemsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdItemsRow get(int index)
		{
			return new grdItemsRow(super.collection.get(index));
		}
		public grdItemsRow newRow()
		{
			return new grdItemsRow(super.collection.newRow());
		}
		public grdItemsRow newRow(boolean autoSelect)
		{
			return new grdItemsRow(super.collection.newRow(autoSelect));
		}
		public grdItemsRow newRowAt(int index)
		{
			return new grdItemsRow(super.collection.newRowAt(index));
		}
		public grdItemsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdItemsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdItemsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void setcolItemsCaption(String value)
		{
			this.grid.setColumnCaption(0, value);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		private void addBoolColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean autoPostBack, int sortOrder, boolean canGrow)
		{
			super.grid.addBoolColumn(caption, captionAlignment, alignment, width, readOnly, autoPostBack, sortOrder, canGrow);
		}
		public java.lang.Object[] getValues()
		{
			java.lang.Object[] listOfValues = new java.lang.Object[this.getRows().size()];
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues[x] = this.getRows().get(x).getValue();
			}
			return listOfValues;
		}
		public java.lang.Object getValue()
		{
			return super.grid.getValue();
		}
		public void setValue(java.lang.Object value)
		{
			super.grid.setValue(value);
		}
		public grdItemsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdItemsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdItemsRowCollection getRows()
		{
			return new grdItemsRowCollection(super.grid.getRows());
		}
		public grdItemsRow getRowByValue(java.lang.Object value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdItemsRow(row);
		}
		public void setcolItemsHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolItemsHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setColumnSelectHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getColumnSelectHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(584, 464);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Core.contextMenuVaccineRemove = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Core.contextMenuVaccineRemoveREMOVEItem = factory.createMenuItem(startControlID.intValue() + 1, "Remove", true, false, new Integer(102300), true, false);
		contextMenus.Core.contextMenuVaccineRemove.add(contextMenus.Core.contextMenuVaccineRemoveREMOVEItem);
		contextMenus.Core.contextMenuVaccineRemoveREMOVEALLItem = factory.createMenuItem(startControlID.intValue() + 2, "Remove All", true, false, new Integer(102148), true, false);
		contextMenus.Core.contextMenuVaccineRemove.add(contextMenus.Core.contextMenuVaccineRemoveREMOVEALLItem);
		form.registerMenu(contextMenus.Core.contextMenuVaccineRemove);


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 16, 18, 67, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Search for:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 493, 432, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(startTabIndex.intValue() + 9), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 408, 432, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 8), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "OK", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 493, 256, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Add to list", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 102, 256, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Clear all", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 16, 256, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Select all", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 88, 16, 440, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,Boolean.FALSE, new Integer(0), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// Grid Controls
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 16, 288, 552, 136, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
		Grid m_grdSelectedItemsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 7), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, contextMenus.Core.contextMenuVaccineRemove, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdSelectedItemsTemp);
		grdSelectedItemsGrid grdSelectedItems = (grdSelectedItemsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdSelectedItemsGrid.class, m_grdSelectedItemsTemp);
		grdSelectedItems.addStringColumn("Diagnosis / Procedures", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdSelectedItems);
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 16, 48, 552, 200, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdItemsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(24), Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdItemsTemp);
		grdItemsGrid grdItems = (grdItemsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdItemsGrid.class, m_grdItemsTemp);
		grdItems.addStringColumn("Diagnosis / Procedures", 0, 0, 480, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdItems.addBoolColumn("Select", 1, 1, -1, false, false, 0, true);
		super.addGrid(grdItems);

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 538, 11, 30, 30, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1009), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.FindEnabled24, this.getImages().Core.FindDisabled24, null, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(1);
	}
	public Button btnOK()
	{
		return (Button)super.getControl(2);
	}
	public Button btnAdd()
	{
		return (Button)super.getControl(3);
	}
	public Button btnClear()
	{
		return (Button)super.getControl(4);
	}
	public Button btnSelectAll()
	{
		return (Button)super.getControl(5);
	}
	public TextBox txtSearch()
	{
		return (TextBox)super.getControl(6);
	}
	public grdSelectedItemsGrid grdSelectedItems()
	{
		return (grdSelectedItemsGrid)super.getGrid(0);
	}
	public grdItemsGrid grdItems()
	{
		return (grdItemsGrid)super.getGrid(1);
	}
	public ImageButton imbSearch()
	{
		return (ImageButton)super.getControl(9);
	}

	public static class Images implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private final class ImageHelper extends ims.framework.utils.ImagePath
		{
			private static final long serialVersionUID = 1L;
			
			private ImageHelper(int id, String path, Integer width, Integer height)
			{
				super(id, path, width, height);
			}
		}
		private Images()
		{
			Core = new CoreImages();
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				FindDisabled24 = new ImageHelper(102172, "Images/Core/FindDisabled_24.png", new Integer(24), new Integer(24));
				FindEnabled24 = new ImageHelper(102175, "Images/Core/Find_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image FindDisabled24;
			public final ims.framework.utils.Image FindEnabled24;
		}
		public final CoreImages Core;
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public CoreNamespace Core = new CoreNamespace();
		public final class CoreNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class VaccineRemove implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int REMOVE = 1;
				public static final int REMOVEALL = 2;
			}
			public void disableAllVaccineRemoveMenuItems()
			{
				this.contextMenuVaccineRemoveREMOVEItem.setEnabled(false);
				this.contextMenuVaccineRemoveREMOVEALLItem.setEnabled(false);
			}
			public void hideAllVaccineRemoveMenuItems()
			{
				this.contextMenuVaccineRemoveREMOVEItem.setVisible(false);
				this.contextMenuVaccineRemoveREMOVEALLItem.setVisible(false);
			}
			private Menu contextMenuVaccineRemove;
			public ReadOnlyMenuItem getVaccineRemoveREMOVEItem()
			{
				return this.contextMenuVaccineRemoveREMOVEItem;
			}
			private MenuItem contextMenuVaccineRemoveREMOVEItem;
			public ReadOnlyMenuItem getVaccineRemoveREMOVEALLItem()
			{
				return this.contextMenuVaccineRemoveREMOVEALLItem;
			}
			private MenuItem contextMenuVaccineRemoveREMOVEALLItem;
		}
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}

	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[71];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_RefMan.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}