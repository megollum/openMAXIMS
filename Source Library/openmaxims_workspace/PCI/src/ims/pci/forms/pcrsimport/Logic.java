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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.65 build 3202.18140)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.forms.pcrsimport;

import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.core.vo.PatientPcrsVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.MessageButtons;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.pci.vo.ClientPCRSImportVo;
import ims.pci.vo.GmsPaymentsVo;
import ims.pci.vo.GmsPaymentsVoCollection;
import ims.pci.vo.GpContractRefVo;
import ims.pci.vo.lookups.GMSPaymentType;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private void processGmsFile(String fileName)
	{
		if(fileName == null)
			return;
		
		StringBuilder errBuffer = new StringBuilder(64 * 1024);
		
		String uploadFileName = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/" + getBaseName(fileName);
		
	    String strLine;
		int line = 1;
		int recordsUpdated = 0;
		
		long t1 = System.currentTimeMillis();
		
		boolean bIgnore = false;
		
	    try
		{
			FileInputStream fstream = new FileInputStream(uploadFileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// Process current line from file
				if(strLine != null && strLine.trim().length() > 0)
				{
					String[] tokens = split(',', strLine);
					
					if(tokens == null || tokens.length < 4)
					{
						errBuffer.append("Error processing line ");
						errBuffer.append(line);
						errBuffer.append(". Each line should have 4 fields separated by comma.\r\n");
					}
					else
					{
						String gmsId = tokens[0] != null ? tokens[0].trim() : null;
						if(gmsId == null || gmsId.trim().length() == 0)
						{
							errBuffer.append("Error processing line ");
							errBuffer.append(line);
							errBuffer.append(". GMS ID cannot be empty.\r\n");
						}
						else
						{
							String clientId = tokens[3] != null ? tokens[3].trim() : null;
							if(clientId == null || clientId.trim().length() == 0)
							{
								errBuffer.append("Error processing line ");
								errBuffer.append(line);
								errBuffer.append(". Client ID cannot be empty.\r\n");
							}
							else
							{
								if(!ConfigFlag.DOM.DATA_MIGRATION_COMPLETED.getValue())
								{
									if(clientId.length() >= 2 && clientId.substring(0, 2).equalsIgnoreCase(ConfigFlag.GEN.PCI_CLIENT_PREFIX.getValue()))
										bIgnore = false;
									else
										bIgnore = true;
								}
								else
								{
									bIgnore = false;
								}
								
								if(bIgnore == false)
								{
									//process line
									ClientPCRSImportVo ci = domain.getClientInfo(clientId);
									
									if(ci == null)
									{
										errBuffer.append(clientId);
										errBuffer.append(" client record is not known to the system. ");
										errBuffer.append(gmsId);
										errBuffer.append(" not recorded.\r\n");
									}
									else
									{
										if(Boolean.TRUE.equals(ci.getIsRie()))
										{
											errBuffer.append(clientId);
											errBuffer.append(" client record is flagged as Recorded In Error. ");
											errBuffer.append(gmsId);
											errBuffer.append(" not recorded.\r\n");
										}
										else
										{
											//update the client record's GMS
											if(ci.getGmsId() == null || ci.getGmsId().length() == 0)
											{
												ci.setGmsId(gmsId);
												domain.updateClientGmsId(ci);
												
												recordsUpdated++;
											}
											else if(!gmsId.equalsIgnoreCase(ci.getGmsId()))
											{
												errBuffer.append(clientId);
												errBuffer.append(" client record already has GMS ID ");
												errBuffer.append(ci.getGmsId());
												errBuffer.append(" recorded. GMS ID ");
												errBuffer.append(gmsId);
												errBuffer.append(" not inserted.\r\n");
											}
										}
									}
								}
							}
						}
					}
				
					line++;
				}
			}
			
			in.close();
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			
			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (ForeignKeyViolationException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (IOException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (UniqueKeyViolationException e)
		{
			e.printStackTrace();
			
			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		finally
		{
			//write the log file
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
			
			String errFileName = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/" + getBaseName(fileName) + df.format(now) + ".txt";
			
			FileOutputStream fos = null;
			try
			{
				fos = new FileOutputStream(errFileName);
				fos.write(errBuffer.toString().getBytes());
				fos.flush();
				fos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				engine.showMessage("The error log file '" + errFileName + "' could not be created: " + e.toString());
			}
			finally
			{
				StringBuilder sbLog = new StringBuilder(errBuffer.length() + 2048);
				
				sbLog.append("PCRS import summary - GMS Ids Import\r\n");
				sbLog.append("===========================================================================================================\r\n");
				sbLog.append("File imported: ");
				sbLog.append(fileName);
				sbLog.append("\r\n");
				sbLog.append(line - 1);
				sbLog.append(" line(s) processed.\r\n");
				sbLog.append(recordsUpdated);
				sbLog.append(" client record(s) updated.\r\n");

				long t2 = System.currentTimeMillis();
				sbLog.append("The import took " + (t2 - t1)/1000.00 + " seconds.\r\n");
				
				if(errBuffer.toString().length() == 0)
					sbLog.append("No errors found.\r\n");
				else
				{
					sbLog.append("An error log file was created on the server :");
					sbLog.append(errFileName);
					sbLog.append("\r\n");
					if(errBuffer.length() > 64*1024)
						sbLog.append("The error log follows below (the first 64 KBytes).\r\n");
					else
						sbLog.append("The error log follows below.\r\n");
				}
		
				sbLog.append("===========================================================================================================\r\n");
				sbLog.append(errBuffer.length() > 64*1024 ? errBuffer.substring(0, 64*1024) : errBuffer);
				
				form.txtErrorLog().setValue(sbLog.toString());
			}
			
		}
		
		form.getLocalContext().setFileUploaded(null);
	}
	private void logError(StringBuilder errBuffer, int line, String err)
	{
		errBuffer.append("Error processing line ");
		errBuffer.append(line);
		errBuffer.append(" : ");
		errBuffer.append(err);
		errBuffer.append(".\r\n");
	}
	private String getBaseName(String fullFileName)
	{
		int ind = fullFileName.lastIndexOf("/");
		if (ind == -1)
		{
			ind = fullFileName.lastIndexOf("\\");			
		}
		if (ind == -1)
			return fullFileName;
		
		if (ind + 1 == fullFileName.length())
			return "";
		
		return fullFileName.substring(ind + 1);
	}

	public String[] split(char delimiter, String str)
	{
		String[] ret = null;
		
		if(str == null)
			return ret;
		
		int len = str.length();
		int delim = 0;
		for (int i = 0; i < len; i++) 
		{
			if(str.charAt(i) == delimiter)
				delim++;
		}
		
		if(delim == 0)
			return ret;
		
		ret = new String[delim + 1];

		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = 0; i < len; i++) 
		{
			if(str.charAt(i) == delimiter)
			{
				ret[index++] = sb.toString();
				sb.setLength(0);
			}
			else
			{
				sb.append(str.charAt(i));
			}
		}
		
		ret[index] = sb.toString();
		
		return ret;
	}

	private void processPaymentFile(String fileName)
	{
		if(fileName == null)
			return;
		
		if(form.getLocalContext().getPaymentPreview() == null)
			throw new CodingRuntimeException("Coding exception, processPaymentFile() preview mode not set.");

		StringBuilder errBuffer = new StringBuilder(64 * 1024);
		HashMap<String, GMSPaymentType> mapType = new HashMap<String, GMSPaymentType>();
		HashMap<String, GpContractRefVo> mapGpContract = new HashMap<String, GpContractRefVo>();
		
		GmsPaymentsVoCollection batch = new GmsPaymentsVoCollection();
		
		String uploadFileName = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/" + getBaseName(fileName);
		
	    String strLine;
		int line = 1;
		int recordsUpdated = 0;
		int recordsIgnored = 0;
		
		long t1 = System.currentTimeMillis();
		
		String clientId;
		String gmsId;
		String gpContractId;
		String yearMonth;
		String amountPaid;
		String paymentType;
		
		DateTime importDate = new DateTime();
		
		boolean bIgnore = false;
		
	    try
		{
			FileInputStream fstream = new FileInputStream(uploadFileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// Process current line from file
				if(strLine != null && strLine.trim().length() > 0)
				{
					String[] tokens = split(',', strLine);
					
					if(tokens == null || tokens.length < 6)
					{
						errBuffer.append("Error processing line ");
						errBuffer.append(line);
						errBuffer.append(". Each line should have 6 fields separated by comma.\r\n");
					}
					else
					{
						Integer yearMonth1 = null;
						Float amountPaid1 = null;
						
						clientId = tokens[0] != null ? tokens[0].trim() : null;
						gmsId = tokens[1];
						gpContractId = tokens[2] != null ? tokens[2].trim() : null;
						yearMonth = tokens[3] != null ? tokens[3].trim() : null;
						amountPaid = tokens[4] != null ? tokens[4].trim() : null;
						paymentType = tokens[5] != null ? tokens[5].trim() : null;
						
						try
						{
							yearMonth1 = Integer.valueOf(yearMonth);
						}
						catch(Exception e)
						{
							
						}
						
						try
						{
							amountPaid1 = Float.valueOf(amountPaid);
						}
						catch(Exception e)
						{
							
						}
						
						
						if(clientId == null || clientId.trim().length() == 0)
						{
							errBuffer.append("Error processing line ");
							errBuffer.append(line);
							errBuffer.append(". Client ID cannot be empty.\r\n");
						}
						else if(gpContractId == null || gpContractId.trim().length() == 0)
						{
							errBuffer.append("Error processing line ");
							errBuffer.append(line);
							errBuffer.append(". Contract ID cannot be empty.\r\n");
						}
						else if(paymentType == null || paymentType.trim().length() == 0)
						{
							errBuffer.append("Error processing line ");
							errBuffer.append(line);
							errBuffer.append(". Payment type cannot be empty.\r\n");
						}
						else if(yearMonth1 == null)
						{
							errBuffer.append("Error processing line ");
							errBuffer.append(line);
							errBuffer.append(". Could not convert yearMonth value of ");
							errBuffer.append(yearMonth);
							errBuffer.append(" to integer .\r\n");
						}
						else if(amountPaid1 == null)
						{
							errBuffer.append("Error processing line ");
							errBuffer.append(line);
							errBuffer.append(". Could not convert amountPaid value of ");
							errBuffer.append(amountPaid);
							errBuffer.append(" to decimal .\r\n");
						}
						else
						{
							if(!ConfigFlag.DOM.DATA_MIGRATION_COMPLETED.getValue())
							{
								if(clientId.length() >= 2 && clientId.substring(0, 2).equalsIgnoreCase(ConfigFlag.GEN.PCI_CLIENT_PREFIX.getValue()))
									bIgnore = false;
								else
									bIgnore = true;
							}
							else
							{
								bIgnore = false;
							}

							if(bIgnore == false)
							{
								//process line
								PatientPcrsVo ci = domain.getClient(clientId.trim());
	
								GpContractRefVo contract = null;
								if(!mapGpContract.containsKey(gpContractId))
								{
									contract = domain.getGpContract(gpContractId);
									mapGpContract.put(gpContractId, contract);
								}
								else
								{
									contract = mapGpContract.get(gpContractId);
								}
	
								GMSPaymentType ptLookup = null;
								if(!mapType.containsKey(paymentType))
								{
									ptLookup = domain.getPaymentType(paymentType);
									mapType.put(paymentType, ptLookup);
								}
								else
								{
									ptLookup = mapType.get(paymentType);
								}
						
								String dbGmsId = (ci == null ? null : domain.getGmsId(ci.getPatientRef().getID_Patient()));
								
								if(ci == null)
								{
									errBuffer.append(clientId);
									errBuffer.append(" client record is not known to the system. Payment ");
									errBuffer.append(amountPaid);
									errBuffer.append(" not recorded.\r\n");
								}
								else if(Boolean.TRUE.equals(ci.getIsRie()))
								{
									errBuffer.append(clientId);
									errBuffer.append(" client record is flagged as Recorded In Error. Payment ");
									errBuffer.append(amountPaid);
									errBuffer.append(" for ");
									errBuffer.append(gpContractId);
									errBuffer.append(" not recorded.\r\n");
								}
								else if(contract == null)
								{
									errBuffer.append("Payment for Client ID ");
									errBuffer.append(clientId);
									errBuffer.append(" not saved. ");
									errBuffer.append(gpContractId);
									errBuffer.append(" contract record is not known to the system. Payment ");
									errBuffer.append(amountPaid);
									errBuffer.append(" not recorded.\r\n");
								}
								else if(ptLookup == null)
								{
									errBuffer.append("Payment for Client ID ");
									errBuffer.append(clientId);
									errBuffer.append(" not saved. Payment type ");
									errBuffer.append(paymentType);
									errBuffer.append(" is not known to the system. Payment ");
									errBuffer.append(amountPaid);
									errBuffer.append(" not recorded.\r\n");
								}
								else if(gmsId != null && dbGmsId != null && !gmsId.equalsIgnoreCase(dbGmsId))
								{
									//check the file GMS id against the DB one
									errBuffer.append("Payment for Client ID ");
									errBuffer.append(clientId);
									errBuffer.append(" not saved. ");
									errBuffer.append(clientId);
									errBuffer.append(" client record already has GMS ID ");
									errBuffer.append(dbGmsId);
									errBuffer.append(" recorded payment GMS ID showing as ");
									errBuffer.append(gmsId);
									errBuffer.append(".\r\n");
								}
								else if(dbGmsId == null)
								{
									errBuffer.append("Payment for Client ID ");
									errBuffer.append(clientId);
									errBuffer.append(" not saved. ");
									errBuffer.append(clientId);
									errBuffer.append(" client record has GMS ID blank");
									errBuffer.append(" recorded payment GMS ID showing as ");
									errBuffer.append(gmsId);
									errBuffer.append(".\r\n");
								}
								else
								{
									if(gmsId == null && dbGmsId != null)
									{
										errBuffer.append("Warning: GmsId for Client ID ");
										errBuffer.append(clientId);
										errBuffer.append(" is null in the import file.\r\n");
									}
									
									if(form.getLocalContext().getPaymentPreview().equals(Boolean.FALSE))
									{
										//insert a payment record
										GmsPaymentsVo payment = new GmsPaymentsVo();
										
										payment.setPatient(ci.getPatientRef());
										payment.setGPContract(contract);
										payment.setAmountPaid(amountPaid1);
										payment.setYearMonth(yearMonth1);
										payment.setGMSPaymentType(ptLookup);
										payment.setImportDate(importDate);
										
										batch.add(payment);
										
										if(recordsUpdated % 50 == 0)
										{
											domain.insertPaymentCollection(batch);
											batch.clear();
										}
									}
								
									recordsUpdated++;
								}
							}
							else
							{
								recordsIgnored++;
							}
						}
					}
				
					line++;
				}
			}
			
			in.close();
			
			if(batch.size() > 0)
				domain.insertPaymentCollection(batch);
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			
			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (ForeignKeyViolationException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (IOException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (UniqueKeyViolationException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();

			String err = e.toString();
			
			logError(errBuffer, line, err);
			
			line++;
		}
		finally
		{
			//write the log file
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
			
			String errFileName = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/" + getBaseName(fileName) + df.format(now) + ".txt";
			
			FileOutputStream fos = null;
			try
			{
				fos = new FileOutputStream(errFileName);
				fos.write(errBuffer.toString().getBytes());
				fos.flush();
				fos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				engine.showMessage("The error log file '" + errFileName + "' could not be created: " + e.toString());
			}
			finally
			{
				StringBuilder sbLog = new StringBuilder(errBuffer.length() + 2048);
				
				if(form.getLocalContext().getPaymentPreview().equals(Boolean.FALSE))
				{
					sbLog.append("PCRS import summary - GMS Payments Import\r\n");
					sbLog.append("===========================================================================================================\r\n");
					sbLog.append("File imported: ");
					sbLog.append(fileName);
					sbLog.append("\r\n");
					sbLog.append(line - 1);
					sbLog.append(" line(s) processed.\r\n");
					sbLog.append(recordsIgnored);
					sbLog.append(" line(s) ignored.\r\n");
					sbLog.append(recordsUpdated);
					sbLog.append(" payment record(s) inserted.\r\n");
	
					long t2 = System.currentTimeMillis();
					sbLog.append("The import took " + (t2 - t1)/1000.00 + " seconds.\r\n");
					
					if(errBuffer.toString().length() == 0)
						sbLog.append("No errors found.\r\n");
					else
					{
						sbLog.append("An error log file was created on the server :");
						sbLog.append(errFileName);
						sbLog.append("\r\n");
						if(errBuffer.length() > 64*1024)
							sbLog.append("The error log follows below (the first 64 KBytes).\r\n");
						else
							sbLog.append("The error log follows below.\r\n");
					}
			
					sbLog.append("===========================================================================================================\r\n");
					sbLog.append(errBuffer.length() > 64*1024 ? errBuffer.substring(0, 64*1024) : errBuffer);
					form.getLocalContext().setFileUploaded(null);
				}
				else
				{
					String msg;
					sbLog.append("PCRS import summary - GMS Payments Import Preview\r\n");
					sbLog.append("===========================================================================================================\r\n");
					sbLog.append("File name: ");
					sbLog.append(fileName);
					sbLog.append("\r\n");
					sbLog.append(line - 1);
					sbLog.append(" line(s) processed.\r\n");
					sbLog.append(recordsIgnored);
					sbLog.append(" line(s) ignored.\r\n");
					sbLog.append(recordsUpdated);
					sbLog.append(" payment record(s) validated.\r\n");
	
					long t2 = System.currentTimeMillis();
					sbLog.append("The import validation took " + (t2 - t1)/1000.00 + " seconds.\r\n");
					
					if(errBuffer.toString().length() == 0)
					{
						sbLog.append("No errors found.\r\n");
						msg = "No validation errors found. Would you like to import the file ?\r\n";
					}
					else
					{
						sbLog.append("An error log file was created on the server :");
						sbLog.append(errFileName);
						sbLog.append("\r\n");
						if(errBuffer.length() > 64*1024)
							sbLog.append("The error log follows below (the first 64 KBytes).\r\n");
						else
							sbLog.append("The error log follows below.\r\n");
						
						msg = (line - 1 - recordsUpdated - recordsIgnored) + " records failed the validation test. Would you like to import the file anyway?\r\n";
					}
			
					sbLog.append("===========================================================================================================\r\n");
					sbLog.append(errBuffer.length() > 64*1024 ? errBuffer.substring(0, 64*1024) : errBuffer);
					
					form.getLocalContext().setPaymentPreview(Boolean.FALSE);
					engine.showMessage(msg, "Confirmation", MessageButtons.YESNO);
				}
				
				form.txtErrorLog().setValue(sbLog.toString());
			}
			
		}
	}
	@Override
	protected void onBtnGmsImportClick() throws PresentationLogicException
	{
		form.txtErrorLog().setValue(null);
		
		if(isValidFile(form.getLocalContext().getFileUploaded(), 4))
			processGmsFile(form.getLocalContext().getFileUploaded());
		else
		{
			StringBuilder sbLog = new StringBuilder();
			
			sbLog.append("PCRS import summary - GMS Ids Import\r\n");
			sbLog.append("===========================================================================================================\r\n");
			sbLog.append("File could not be imported: ");
			sbLog.append(form.getLocalContext().getFileUploaded());
			sbLog.append("\r\n");
			sbLog.append("The first line has an incorrect number of fields.");
			
			form.txtErrorLog().setValue(sbLog.toString());
		}
	}
	@Override
	protected void onBtnPaymentImportClick() throws PresentationLogicException
	{
		form.txtErrorLog().setValue(null);
		
		if(isValidFile(form.getLocalContext().getFileUploaded(), 6))
		{
			String msg = getRecordCountForCurrentMonthYear(form.getLocalContext().getFileUploaded());
		
			form.getLocalContext().setPaymentPreview(Boolean.TRUE);
			if(msg == null)
			{
				processPaymentFile(form.getLocalContext().getFileUploaded());
			}
			else
			{
				engine.showMessage(msg, "Confirmation", MessageButtons.YESNO);
			}
		}
		else
		{
			StringBuilder sbLog = new StringBuilder();
			
			sbLog.append("PCRS import summary - Payment Import\r\n");
			sbLog.append("===========================================================================================================\r\n");
			sbLog.append("File could not be imported: ");
			sbLog.append(form.getLocalContext().getFileUploaded());
			sbLog.append("\r\n");
			sbLog.append("The first line has an incorrect number of fields.");
			
			form.txtErrorLog().setValue(sbLog.toString());
		}
	}
	private String getRecordCountForCurrentMonthYear(String fileUploaded)
	{
		if(fileUploaded == null)
			return null;
		
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> storage = new HashMap<Integer, Integer>();
		
		String uploadFileName = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/" + getBaseName(fileUploaded);
		
	    String strLine;
		
		//long t1 = System.currentTimeMillis();
		
		String yearMonth;
		
	    try
		{
			FileInputStream fstream = new FileInputStream(uploadFileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// Process current line from file
				if(strLine != null || strLine.trim().length() > 0)
				{
					String[] tokens = split(',', strLine);
					
					if(tokens != null && tokens.length >= 6)
					{
						Integer yearMonth1 = null;
						
						yearMonth = tokens[3] != null ? tokens[3].trim() : null;
						
						try
						{
							yearMonth1 = Integer.valueOf(yearMonth);
						}
						catch(Exception e)
						{
							
						}
						
						if(yearMonth1 != null && storage.get(yearMonth1) == null)
						{
							int count = domain.checkYearMonthRecords(yearMonth1);
							
							storage.put(yearMonth1, count);
						}
					}
				}
			}
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	    
	    //long t2 = System.currentTimeMillis();
	    
	    //System.out.println("getRecordCountForCurrentMonthYear() took " + (t2 - t1) + " miliseconds.");
	    
	    if(storage.isEmpty())
	    	return null;
	    
	    Set<Integer> keys = storage.keySet();
	    
	    int count = 0;
	    for (Integer key : keys)
		{
			Integer val = storage.get(key);
			
			if(val > 0)
			{
				sb.append("There are ");
				sb.append(val);
				sb.append(" records for month/year ");
				sb.append(key);
				sb.append(".\r\n");
				
				count++;
				
				if(count > 15)
				{
					sb.append("...\r\n");
					
					break;
				}
			}
		}
		
	    sb.append("\r\n\r\n");
	    sb.append("Do you want to continue ?");
	    
	    return sb.toString();
	}
	@Override
	protected void onfileupldFileUploaded(String fileName)
	{
		form.getLocalContext().setFileUploaded(fileName);
		form.txtErrorLog().setValue("Processing...");
	}
	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if(DialogResult.YES.equals(result))
		{
			processPaymentFile(form.getLocalContext().getFileUploaded());
		}
		else
			form.getLocalContext().setFileUploaded(null);
	}

	private boolean isValidFile(String fileUploaded, int fields)
	{
		if(fileUploaded == null)
			return false;
		
		String uploadFileName = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "/" + getBaseName(fileUploaded);
		
	    String strLine;
		
	    try
		{
			FileInputStream fstream = new FileInputStream(uploadFileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// Process current line from file
				if(strLine != null || strLine.trim().length() > 0)
				{
					String[] tokens = split(',', strLine);
					
					if(tokens != null && tokens.length == fields)
					{
						return true;
					}
					else
						return false;
				}
			}
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
			return false;
		}
	    
	    return false;
	}
	
}