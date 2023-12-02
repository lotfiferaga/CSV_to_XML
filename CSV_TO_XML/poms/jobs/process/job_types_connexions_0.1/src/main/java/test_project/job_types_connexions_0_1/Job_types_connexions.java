// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package test_project.job_types_connexions_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

//the import part of tJava_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: Job_types_connexions Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Job_types_connexions implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (ENV != null) {

				this.setProperty("ENV", ENV.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String ENV;

		public String getENV() {
			return this.ENV;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Job_types_connexions";
	private final String projectName = "TEST_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Job_types_connexions.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job_types_connexions.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedFileOutputXML_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFilterRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tJava_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMsgBox_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tMsgBox_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tJava_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tMsgBox_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append(",type=" + type);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String errorMessage;

		public String getErrorMessage() {
			return this.errorMessage;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

					this.errorMessage = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

					this.errorMessage = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.errorMessage, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.errorMessage, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append(",type=" + type);
			sb.append(",errorMessage=" + errorMessage);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append(",type=" + type);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class adding_typeStruct implements routines.system.IPersistableRow<adding_typeStruct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append(",type=" + type);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(adding_typeStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_1Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_1Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public Integer Id;

		public Integer getId() {
			return this.Id;
		}

		public Float SepalLengthCm;

		public Float getSepalLengthCm() {
			return this.SepalLengthCm;
		}

		public Float SepalWidthCm;

		public Float getSepalWidthCm() {
			return this.SepalWidthCm;
		}

		public Float PetalLengthCm;

		public Float getPetalLengthCm() {
			return this.PetalLengthCm;
		}

		public Float PetalWidthCm;

		public Float getPetalWidthCm() {
			return this.PetalWidthCm;
		}

		public String Species;

		public String getSpecies() {
			return this.Species;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.Id = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.SepalLengthCm = null;
					} else {
						this.SepalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.SepalWidthCm = null;
					} else {
						this.SepalWidthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalLengthCm = null;
					} else {
						this.PetalLengthCm = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PetalWidthCm = null;
					} else {
						this.PetalWidthCm = dis.readFloat();
					}

					this.Species = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.Id, dos);

				// Float

				if (this.SepalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalLengthCm);
				}

				// Float

				if (this.SepalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.SepalWidthCm);
				}

				// Float

				if (this.PetalLengthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalLengthCm);
				}

				// Float

				if (this.PetalWidthCm == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PetalWidthCm);
				}

				// String

				writeString(this.Species, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Id=" + String.valueOf(Id));
			sb.append(",SepalLengthCm=" + String.valueOf(SepalLengthCm));
			sb.append(",SepalWidthCm=" + String.valueOf(SepalWidthCm));
			sb.append(",PetalLengthCm=" + String.valueOf(PetalLengthCm));
			sb.append(",PetalWidthCm=" + String.valueOf(PetalWidthCm));
			sb.append(",Species=" + Species);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tFileInputDelimited_2Process(globalMap);

				row2Struct row2 = new row2Struct();
				row2Struct row3 = row2;
				adding_typeStruct adding_type = new adding_typeStruct();
				adding_typeStruct row5 = adding_type;
				row6Struct row6 = new row6Struct();
				row7Struct row7 = new row7Struct();

				/**
				 * [tFileOutputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_2", false);
				start_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tFileOutputDelimited_2 = 0;

				String fileName_tFileOutputDelimited_2 = "";
				fileName_tFileOutputDelimited_2 = (new java.io.File(
						"C:/Users/Abdelhak Pedro/Documents/Talend/Out/filter_ouput.csv")).getAbsolutePath()
								.replace("\\", "/");
				String fullName_tFileOutputDelimited_2 = null;
				String extension_tFileOutputDelimited_2 = null;
				String directory_tFileOutputDelimited_2 = null;
				if ((fileName_tFileOutputDelimited_2.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_2.lastIndexOf(".") < fileName_tFileOutputDelimited_2
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
						extension_tFileOutputDelimited_2 = "";
					} else {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
								fileName_tFileOutputDelimited_2.lastIndexOf("."));
						extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2
								.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
							fileName_tFileOutputDelimited_2.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_2.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
								fileName_tFileOutputDelimited_2.lastIndexOf("."));
						extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2
								.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
						extension_tFileOutputDelimited_2 = "";
					}
					directory_tFileOutputDelimited_2 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_2 = true;
				java.io.File filetFileOutputDelimited_2 = new java.io.File(fileName_tFileOutputDelimited_2);
				globalMap.put("tFileOutputDelimited_2_FILE_NAME", fileName_tFileOutputDelimited_2);
				if (filetFileOutputDelimited_2.exists()) {
					isFileGenerated_tFileOutputDelimited_2 = false;
				}
				String[] headColutFileOutputDelimited_2 = new String[7];
				class CSVBasicSet_tFileOutputDelimited_2 {
					private char field_Delim;
					private char row_Delim;
					private char escape;
					private char textEnclosure;
					private boolean useCRLFRecordDelimiter;

					public boolean isUseCRLFRecordDelimiter() {
						return useCRLFRecordDelimiter;
					}

					public void setFieldSeparator(String fieldSep) throws IllegalArgumentException {
						char field_Delim_tFileOutputDelimited_2[] = null;

						// support passing value (property: Field Separator) by 'context.fs' or
						// 'globalMap.get("fs")'.
						if (fieldSep.length() > 0) {
							field_Delim_tFileOutputDelimited_2 = fieldSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Field Separator must be assigned a char.");
						}
						this.field_Delim = field_Delim_tFileOutputDelimited_2[0];
					}

					public char getFieldDelim() {
						if (this.field_Delim == 0) {
							setFieldSeparator(",");
						}
						return this.field_Delim;
					}

					public void setRowSeparator(String rowSep) {
						if ("\r\n".equals(rowSep)) {
							useCRLFRecordDelimiter = true;
							return;
						}
						char row_DelimtFileOutputDelimited_2[] = null;

						// support passing value (property: Row Separator) by 'context.rs' or
						// 'globalMap.get("rs")'.
						if (rowSep.length() > 0) {
							row_DelimtFileOutputDelimited_2 = rowSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Row Separator must be assigned a char.");
						}
						this.row_Delim = row_DelimtFileOutputDelimited_2[0];
					}

					public char getRowDelim() {
						if (this.row_Delim == 0) {
							setRowSeparator("\n");
						}
						return this.row_Delim;
					}

					public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure)
							throws IllegalArgumentException {
						if (strEscape.length() <= 0) {
							throw new IllegalArgumentException("Escape Char must be assigned a char.");
						}

						if ("".equals(strTextEnclosure))
							strTextEnclosure = "\0";
						char textEnclosure_tFileOutputDelimited_2[] = null;

						if (strTextEnclosure.length() > 0) {
							textEnclosure_tFileOutputDelimited_2 = strTextEnclosure.toCharArray();
						} else {
							throw new IllegalArgumentException("Text Enclosure must be assigned a char.");
						}

						this.textEnclosure = textEnclosure_tFileOutputDelimited_2[0];

						if (("\\").equals(strEscape)) {
							this.escape = '\\';
						} else if (strEscape.equals(strTextEnclosure)) {
							this.escape = this.textEnclosure;
						} else {
							// the default escape mode is double escape
							this.escape = this.textEnclosure;
						}

					}

					public char getEscapeChar() {
						return (char) this.escape;
					}

					public char getTextEnclosure() {
						return this.textEnclosure;
					}
				}

				int nb_line_tFileOutputDelimited_2 = 0;
				int splitedFileNo_tFileOutputDelimited_2 = 0;
				int currentRow_tFileOutputDelimited_2 = 0;

				CSVBasicSet_tFileOutputDelimited_2 csvSettings_tFileOutputDelimited_2 = new CSVBasicSet_tFileOutputDelimited_2();
				csvSettings_tFileOutputDelimited_2.setFieldSeparator(",");
				csvSettings_tFileOutputDelimited_2.setRowSeparator("\n");
				csvSettings_tFileOutputDelimited_2.setEscapeAndTextEnclosure(" ", " ");
				// create directory only if not exists
				if (directory_tFileOutputDelimited_2 != null && directory_tFileOutputDelimited_2.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_2 = new java.io.File(directory_tFileOutputDelimited_2);
					if (!dir_tFileOutputDelimited_2.exists()) {
						dir_tFileOutputDelimited_2.mkdirs();
					}
				}
				com.talend.csv.CSVWriter CsvWritertFileOutputDelimited_2 = null;

				CsvWritertFileOutputDelimited_2 = new com.talend.csv.CSVWriter(
						new java.io.BufferedWriter(new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(fileName_tFileOutputDelimited_2, true), "US-ASCII")));
				CsvWritertFileOutputDelimited_2.setSeparator(csvSettings_tFileOutputDelimited_2.getFieldDelim());
				if (!csvSettings_tFileOutputDelimited_2.isUseCRLFRecordDelimiter()
						&& csvSettings_tFileOutputDelimited_2.getRowDelim() != '\r'
						&& csvSettings_tFileOutputDelimited_2.getRowDelim() != '\n') {
					CsvWritertFileOutputDelimited_2.setLineEnd("" + csvSettings_tFileOutputDelimited_2.getRowDelim());
				}
				if (filetFileOutputDelimited_2.length() == 0) {
					headColutFileOutputDelimited_2[0] = "Id";
					headColutFileOutputDelimited_2[1] = "SepalLengthCm";
					headColutFileOutputDelimited_2[2] = "SepalWidthCm";
					headColutFileOutputDelimited_2[3] = "PetalLengthCm";
					headColutFileOutputDelimited_2[4] = "PetalWidthCm";
					headColutFileOutputDelimited_2[5] = "Species";
					headColutFileOutputDelimited_2[6] = "type";
					CsvWritertFileOutputDelimited_2.writeNext(headColutFileOutputDelimited_2);
					CsvWritertFileOutputDelimited_2.flush();
				}
				CsvWritertFileOutputDelimited_2.setEscapeChar(csvSettings_tFileOutputDelimited_2.getEscapeChar());
				CsvWritertFileOutputDelimited_2.setQuoteChar(csvSettings_tFileOutputDelimited_2.getTextEnclosure());
				CsvWritertFileOutputDelimited_2.setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);

				resourceMap.put("CsvWriter_tFileOutputDelimited_2", CsvWritertFileOutputDelimited_2);
				resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

				/**
				 * [tFileOutputDelimited_2 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_3", false);
				start_Hash.put("tFileOutputDelimited_3", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
				}

				int tos_count_tFileOutputDelimited_3 = 0;

				String fileName_tFileOutputDelimited_3 = "";
				fileName_tFileOutputDelimited_3 = (new java.io.File(
						"C:/Users/Abdelhak Pedro/Documents/Talend/Out/filter_rejects.csv")).getAbsolutePath()
								.replace("\\", "/");
				String fullName_tFileOutputDelimited_3 = null;
				String extension_tFileOutputDelimited_3 = null;
				String directory_tFileOutputDelimited_3 = null;
				if ((fileName_tFileOutputDelimited_3.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_3.lastIndexOf(".") < fileName_tFileOutputDelimited_3
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3;
						extension_tFileOutputDelimited_3 = "";
					} else {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
								fileName_tFileOutputDelimited_3.lastIndexOf("."));
						extension_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3
								.substring(fileName_tFileOutputDelimited_3.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
							fileName_tFileOutputDelimited_3.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_3.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
								fileName_tFileOutputDelimited_3.lastIndexOf("."));
						extension_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3
								.substring(fileName_tFileOutputDelimited_3.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3;
						extension_tFileOutputDelimited_3 = "";
					}
					directory_tFileOutputDelimited_3 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_3 = true;
				java.io.File filetFileOutputDelimited_3 = new java.io.File(fileName_tFileOutputDelimited_3);
				globalMap.put("tFileOutputDelimited_3_FILE_NAME", fileName_tFileOutputDelimited_3);
				if (filetFileOutputDelimited_3.exists()) {
					isFileGenerated_tFileOutputDelimited_3 = false;
				}
				String[] headColutFileOutputDelimited_3 = new String[7];
				class CSVBasicSet_tFileOutputDelimited_3 {
					private char field_Delim;
					private char row_Delim;
					private char escape;
					private char textEnclosure;
					private boolean useCRLFRecordDelimiter;

					public boolean isUseCRLFRecordDelimiter() {
						return useCRLFRecordDelimiter;
					}

					public void setFieldSeparator(String fieldSep) throws IllegalArgumentException {
						char field_Delim_tFileOutputDelimited_3[] = null;

						// support passing value (property: Field Separator) by 'context.fs' or
						// 'globalMap.get("fs")'.
						if (fieldSep.length() > 0) {
							field_Delim_tFileOutputDelimited_3 = fieldSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Field Separator must be assigned a char.");
						}
						this.field_Delim = field_Delim_tFileOutputDelimited_3[0];
					}

					public char getFieldDelim() {
						if (this.field_Delim == 0) {
							setFieldSeparator(",");
						}
						return this.field_Delim;
					}

					public void setRowSeparator(String rowSep) {
						if ("\r\n".equals(rowSep)) {
							useCRLFRecordDelimiter = true;
							return;
						}
						char row_DelimtFileOutputDelimited_3[] = null;

						// support passing value (property: Row Separator) by 'context.rs' or
						// 'globalMap.get("rs")'.
						if (rowSep.length() > 0) {
							row_DelimtFileOutputDelimited_3 = rowSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Row Separator must be assigned a char.");
						}
						this.row_Delim = row_DelimtFileOutputDelimited_3[0];
					}

					public char getRowDelim() {
						if (this.row_Delim == 0) {
							setRowSeparator("\n");
						}
						return this.row_Delim;
					}

					public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure)
							throws IllegalArgumentException {
						if (strEscape.length() <= 0) {
							throw new IllegalArgumentException("Escape Char must be assigned a char.");
						}

						if ("".equals(strTextEnclosure))
							strTextEnclosure = "\0";
						char textEnclosure_tFileOutputDelimited_3[] = null;

						if (strTextEnclosure.length() > 0) {
							textEnclosure_tFileOutputDelimited_3 = strTextEnclosure.toCharArray();
						} else {
							throw new IllegalArgumentException("Text Enclosure must be assigned a char.");
						}

						this.textEnclosure = textEnclosure_tFileOutputDelimited_3[0];

						if (("\\").equals(strEscape)) {
							this.escape = '\\';
						} else if (strEscape.equals(strTextEnclosure)) {
							this.escape = this.textEnclosure;
						} else {
							// the default escape mode is double escape
							this.escape = this.textEnclosure;
						}

					}

					public char getEscapeChar() {
						return (char) this.escape;
					}

					public char getTextEnclosure() {
						return this.textEnclosure;
					}
				}

				int nb_line_tFileOutputDelimited_3 = 0;
				int splitedFileNo_tFileOutputDelimited_3 = 0;
				int currentRow_tFileOutputDelimited_3 = 0;

				CSVBasicSet_tFileOutputDelimited_3 csvSettings_tFileOutputDelimited_3 = new CSVBasicSet_tFileOutputDelimited_3();
				csvSettings_tFileOutputDelimited_3.setFieldSeparator(",");
				csvSettings_tFileOutputDelimited_3.setRowSeparator("\n");
				csvSettings_tFileOutputDelimited_3.setEscapeAndTextEnclosure(" ", " ");
				// create directory only if not exists
				if (directory_tFileOutputDelimited_3 != null && directory_tFileOutputDelimited_3.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_3 = new java.io.File(directory_tFileOutputDelimited_3);
					if (!dir_tFileOutputDelimited_3.exists()) {
						dir_tFileOutputDelimited_3.mkdirs();
					}
				}
				com.talend.csv.CSVWriter CsvWritertFileOutputDelimited_3 = null;

				CsvWritertFileOutputDelimited_3 = new com.talend.csv.CSVWriter(
						new java.io.BufferedWriter(new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(fileName_tFileOutputDelimited_3, true), "US-ASCII")));
				CsvWritertFileOutputDelimited_3.setSeparator(csvSettings_tFileOutputDelimited_3.getFieldDelim());
				if (!csvSettings_tFileOutputDelimited_3.isUseCRLFRecordDelimiter()
						&& csvSettings_tFileOutputDelimited_3.getRowDelim() != '\r'
						&& csvSettings_tFileOutputDelimited_3.getRowDelim() != '\n') {
					CsvWritertFileOutputDelimited_3.setLineEnd("" + csvSettings_tFileOutputDelimited_3.getRowDelim());
				}
				if (filetFileOutputDelimited_3.length() == 0) {
					headColutFileOutputDelimited_3[0] = "Id";
					headColutFileOutputDelimited_3[1] = "SepalLengthCm";
					headColutFileOutputDelimited_3[2] = "SepalWidthCm";
					headColutFileOutputDelimited_3[3] = "PetalLengthCm";
					headColutFileOutputDelimited_3[4] = "PetalWidthCm";
					headColutFileOutputDelimited_3[5] = "Species";
					headColutFileOutputDelimited_3[6] = "type";
					CsvWritertFileOutputDelimited_3.writeNext(headColutFileOutputDelimited_3);
					CsvWritertFileOutputDelimited_3.flush();
				}
				CsvWritertFileOutputDelimited_3.setEscapeChar(csvSettings_tFileOutputDelimited_3.getEscapeChar());
				CsvWritertFileOutputDelimited_3.setQuoteChar(csvSettings_tFileOutputDelimited_3.getTextEnclosure());
				CsvWritertFileOutputDelimited_3.setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);

				resourceMap.put("CsvWriter_tFileOutputDelimited_3", CsvWritertFileOutputDelimited_3);
				resourceMap.put("nb_line_tFileOutputDelimited_3", nb_line_tFileOutputDelimited_3);

				/**
				 * [tFileOutputDelimited_3 begin ] stop
				 */

				/**
				 * [tFilterRow_1 begin ] start
				 */

				ok_Hash.put("tFilterRow_1", false);
				start_Hash.put("tFilterRow_1", System.currentTimeMillis());

				currentComponent = "tFilterRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tFilterRow_1 = 0;

				int nb_line_tFilterRow_1 = 0;
				int nb_line_ok_tFilterRow_1 = 0;
				int nb_line_reject_tFilterRow_1 = 0;

				class Operator_tFilterRow_1 {
					private String sErrorMsg = "";
					private boolean bMatchFlag = true;
					private String sUnionFlag = "&&";

					public Operator_tFilterRow_1(String unionFlag) {
						sUnionFlag = unionFlag;
						bMatchFlag = "||".equals(unionFlag) ? false : true;
					}

					public String getErrorMsg() {
						if (sErrorMsg != null && sErrorMsg.length() > 1)
							return sErrorMsg.substring(1);
						else
							return null;
					}

					public boolean getMatchFlag() {
						return bMatchFlag;
					}

					public void matches(boolean partMatched, String reason) {
						// no need to care about the next judgement
						if ("||".equals(sUnionFlag) && bMatchFlag) {
							return;
						}

						if (!partMatched) {
							sErrorMsg += "|" + reason;
						}

						if ("||".equals(sUnionFlag))
							bMatchFlag = bMatchFlag || partMatched;
						else
							bMatchFlag = bMatchFlag && partMatched;
					}
				}

				/**
				 * [tFilterRow_1 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_1", false);
				start_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "adding_type");
				}

				int tos_count_tFileOutputDelimited_1 = 0;

				String fileName_tFileOutputDelimited_1 = "";
				fileName_tFileOutputDelimited_1 = (new java.io.File(
						"C:/Users/Abdelhak Pedro/Documents/Talend/Out/map_output.txt")).getAbsolutePath().replace("\\",
								"/");
				String fullName_tFileOutputDelimited_1 = null;
				String extension_tFileOutputDelimited_1 = null;
				String directory_tFileOutputDelimited_1 = null;
				if ((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
								fileName_tFileOutputDelimited_1.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
							fileName_tFileOutputDelimited_1.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
								fileName_tFileOutputDelimited_1.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					}
					directory_tFileOutputDelimited_1 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_1 = true;
				java.io.File filetFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME", fileName_tFileOutputDelimited_1);
				if (filetFileOutputDelimited_1.exists()) {
					isFileGenerated_tFileOutputDelimited_1 = false;
				}
				String[] headColutFileOutputDelimited_1 = new String[7];
				class CSVBasicSet_tFileOutputDelimited_1 {
					private char field_Delim;
					private char row_Delim;
					private char escape;
					private char textEnclosure;
					private boolean useCRLFRecordDelimiter;

					public boolean isUseCRLFRecordDelimiter() {
						return useCRLFRecordDelimiter;
					}

					public void setFieldSeparator(String fieldSep) throws IllegalArgumentException {
						char field_Delim_tFileOutputDelimited_1[] = null;

						// support passing value (property: Field Separator) by 'context.fs' or
						// 'globalMap.get("fs")'.
						if (fieldSep.length() > 0) {
							field_Delim_tFileOutputDelimited_1 = fieldSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Field Separator must be assigned a char.");
						}
						this.field_Delim = field_Delim_tFileOutputDelimited_1[0];
					}

					public char getFieldDelim() {
						if (this.field_Delim == 0) {
							setFieldSeparator(",");
						}
						return this.field_Delim;
					}

					public void setRowSeparator(String rowSep) {
						if ("\r\n".equals(rowSep)) {
							useCRLFRecordDelimiter = true;
							return;
						}
						char row_DelimtFileOutputDelimited_1[] = null;

						// support passing value (property: Row Separator) by 'context.rs' or
						// 'globalMap.get("rs")'.
						if (rowSep.length() > 0) {
							row_DelimtFileOutputDelimited_1 = rowSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Row Separator must be assigned a char.");
						}
						this.row_Delim = row_DelimtFileOutputDelimited_1[0];
					}

					public char getRowDelim() {
						if (this.row_Delim == 0) {
							setRowSeparator("\n");
						}
						return this.row_Delim;
					}

					public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure)
							throws IllegalArgumentException {
						if (strEscape.length() <= 0) {
							throw new IllegalArgumentException("Escape Char must be assigned a char.");
						}

						if ("".equals(strTextEnclosure))
							strTextEnclosure = "\0";
						char textEnclosure_tFileOutputDelimited_1[] = null;

						if (strTextEnclosure.length() > 0) {
							textEnclosure_tFileOutputDelimited_1 = strTextEnclosure.toCharArray();
						} else {
							throw new IllegalArgumentException("Text Enclosure must be assigned a char.");
						}

						this.textEnclosure = textEnclosure_tFileOutputDelimited_1[0];

						if (("\\").equals(strEscape)) {
							this.escape = '\\';
						} else if (strEscape.equals(strTextEnclosure)) {
							this.escape = this.textEnclosure;
						} else {
							// the default escape mode is double escape
							this.escape = this.textEnclosure;
						}

					}

					public char getEscapeChar() {
						return (char) this.escape;
					}

					public char getTextEnclosure() {
						return this.textEnclosure;
					}
				}

				int nb_line_tFileOutputDelimited_1 = 0;
				int splitedFileNo_tFileOutputDelimited_1 = 0;
				int currentRow_tFileOutputDelimited_1 = 0;

				CSVBasicSet_tFileOutputDelimited_1 csvSettings_tFileOutputDelimited_1 = new CSVBasicSet_tFileOutputDelimited_1();
				csvSettings_tFileOutputDelimited_1.setFieldSeparator(",");
				csvSettings_tFileOutputDelimited_1.setRowSeparator("\n");
				csvSettings_tFileOutputDelimited_1.setEscapeAndTextEnclosure(" ", " ");
				// create directory only if not exists
				if (directory_tFileOutputDelimited_1 != null && directory_tFileOutputDelimited_1.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_1 = new java.io.File(directory_tFileOutputDelimited_1);
					if (!dir_tFileOutputDelimited_1.exists()) {
						dir_tFileOutputDelimited_1.mkdirs();
					}
				}
				com.talend.csv.CSVWriter CsvWritertFileOutputDelimited_1 = null;

				CsvWritertFileOutputDelimited_1 = new com.talend.csv.CSVWriter(
						new java.io.BufferedWriter(new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(fileName_tFileOutputDelimited_1, true), "US-ASCII")));
				CsvWritertFileOutputDelimited_1.setSeparator(csvSettings_tFileOutputDelimited_1.getFieldDelim());
				if (!csvSettings_tFileOutputDelimited_1.isUseCRLFRecordDelimiter()
						&& csvSettings_tFileOutputDelimited_1.getRowDelim() != '\r'
						&& csvSettings_tFileOutputDelimited_1.getRowDelim() != '\n') {
					CsvWritertFileOutputDelimited_1.setLineEnd("" + csvSettings_tFileOutputDelimited_1.getRowDelim());
				}
				CsvWritertFileOutputDelimited_1.setEscapeChar(csvSettings_tFileOutputDelimited_1.getEscapeChar());
				CsvWritertFileOutputDelimited_1.setQuoteChar(csvSettings_tFileOutputDelimited_1.getTextEnclosure());
				CsvWritertFileOutputDelimited_1.setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);

				resourceMap.put("CsvWriter_tFileOutputDelimited_1", CsvWritertFileOutputDelimited_1);
				resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

				/**
				 * [tFileOutputDelimited_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				tHash_Lookup_row4.initGet();

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				adding_typeStruct adding_type_tmp = new adding_typeStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tAdvancedFileOutputXML_1 begin ] start
				 */

				ok_Hash.put("tAdvancedFileOutputXML_1", false);
				start_Hash.put("tAdvancedFileOutputXML_1", System.currentTimeMillis());

				currentComponent = "tAdvancedFileOutputXML_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tAdvancedFileOutputXML_1 = 0;

				int nb_line_tAFOX_1 = 0;

				boolean needRoot_tAFOX_1 = true;

				String fileName_tAFOX_1 = "C:/Users/Abdelhak Pedro/Documents/Talend/Out/Output.xml";
				Boolean alreadyExistsFile_tAFOX_1 = new java.io.File(fileName_tAFOX_1).exists();
				fileName_tAFOX_1 = new java.io.File(fileName_tAFOX_1).getAbsolutePath().replace("\\", "/");

				String fileNameWithoutSuffix_tAFOX_1 = "";

				if (fileName_tAFOX_1.indexOf("/") < 0) {
					throw new IllegalArgumentException("not a correct file name.");
				} else {
					String tail_tAFOX_1 = fileName_tAFOX_1.substring(fileName_tAFOX_1.lastIndexOf("/"));
					fileNameWithoutSuffix_tAFOX_1 = tail_tAFOX_1.lastIndexOf(".") > 0
							? fileName_tAFOX_1.substring(0, fileName_tAFOX_1.lastIndexOf("."))
							: fileName_tAFOX_1;
				}

				final String file_tAFOX_1 = fileNameWithoutSuffix_tAFOX_1;

				java.io.File createFiletAFOX_1 = new java.io.File(fileName_tAFOX_1);

				if (!createFiletAFOX_1.exists()) {
					(new java.io.File(fileName_tAFOX_1.substring(0, fileName_tAFOX_1.lastIndexOf("/")))).mkdirs();
					needRoot_tAFOX_1 = true;
				}

				java.util.List<java.util.List<String>> groupbyList_tAFOX_1 = new java.util.ArrayList<java.util.List<String>>();
				final java.util.Map<String, String> valueMap_tAFOX_1 = new java.util.HashMap<String, String>();

				class NestXMLTool_tAFOX_1 {
					public void parseAndAdd(org.dom4j.Element nestRoot, String value) {
						try {
							org.dom4j.Document doc4Str = org.dom4j.DocumentHelper
									.parseText("<root>" + value + "</root>");
							nestRoot.setContent(doc4Str.getRootElement().content());
						} catch (java.lang.Exception e) {
							globalMap.put("tAFOX_1_ERROR_MESSAGE", e.getMessage());
							nestRoot.setText(value);
						}
					}

					public void setText(org.dom4j.Element element, String value) {
						if (value.startsWith("<![CDATA[") && value.endsWith("]]>")) {
							String text = value.substring(9, value.length() - 3);
							element.addCDATA(text);
						} else {
							element.setText(value);
						}
					}

					public void appendContent(org.dom4j.Element element, org.dom4j.Document doc) {
						element.appendContent(doc);
					}

					public void replaceDefaultNameSpace(org.dom4j.Element nestRoot) {
						if (nestRoot != null) {
							boolean isDefaultNameSpaceAtRoot = ""
									.equals(nestRoot.getQName().getNamespace().getPrefix());
							for (org.dom4j.Element tmp : (java.util.List<org.dom4j.Element>) nestRoot.elements()) {
								if (("").equals(tmp.getQName().getNamespace().getURI())
										&& ("").equals(tmp.getQName().getNamespace().getPrefix())
										&& isDefaultNameSpaceAtRoot) {
									tmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(),
											nestRoot.getQName().getNamespace()));
								}
								replaceDefaultNameSpace(tmp);
							}
						}
					}

					public void removeEmptyElement(org.dom4j.Element root) {
						if (root != null) {
							for (org.dom4j.Element tmp : (java.util.List<org.dom4j.Element>) root.elements()) {
								removeEmptyElement(tmp);
							}
							if (root.content().size() == 0 && root.attributes().size() == 0
									&& root.declaredNamespaces().size() == 0) {
								if (root.getParent() != null) {
									root.getParent().remove(root);
								}
							}
						}
					}

					/**
					 * remove the whiteSpace Node between the elements when appending the source
					 * file under dom4j
					 * 
					 * @param root
					 */
					public void removeWhiteSpaceTextNode(org.dom4j.Element root) {
						if (root != null) {
							List<org.dom4j.Node> textNodes = new java.util.ArrayList<org.dom4j.Node>();
							for (int i = 0; i < root.nodeCount(); i++) {
								if (root.node(i).getNodeType() == org.dom4j.Node.ELEMENT_NODE) {
									removeWhiteSpaceTextNode((org.dom4j.Element) root.node(i));
								} else if (root.node(i).getNodeType() == org.dom4j.Node.TEXT_NODE) {
									textNodes.add(root.node(i));
								}
							}
							if (root.nodeCount() > 1) { // when root.nodeCount==1, that means the text node is the
														// content of the element
								for (org.dom4j.Node textNode : textNodes) {
									if (textNode.getText() == null || "".equals(textNode.getText().trim())) {
										root.remove(textNode);
									}
								}
							}
						}
					}

					/**
					 * Get element by QNames which get from the path
					 */
					public org.dom4j.Element getElement(org.dom4j.Element parent, String[] elemNames) {
						if (parent == null) {
							return null;
						}
						org.dom4j.Element tempElem = parent;
						for (int i = 0; elemNames != null && i < elemNames.length; i++) {
							tempElem = tempElem.element(parent.getQName(elemNames[i]));
							if (tempElem == null) {
								return null;
							}
						}
						return tempElem;
					}
				}

				final NestXMLTool_tAFOX_1 nestXMLTool_tAFOX_1 = new NestXMLTool_tAFOX_1();
				// sort group root element for judgement of group
				java.util.List<org.dom4j.Element> groupElementList_tAFOX_1 = new java.util.ArrayList<org.dom4j.Element>();
				org.dom4j.Element root4Group_tAFOX_1 = null;
				org.dom4j.Document doc_tAFOX_1 = null;

				final java.util.Map<String, org.dom4j.Branch> nameToElement_tAFOX_1 = new java.util.HashMap<String, org.dom4j.Branch>();

				doc_tAFOX_1 = org.dom4j.DocumentHelper.createDocument();

				org.dom4j.io.OutputFormat format_tAFOX_1 = org.dom4j.io.OutputFormat.createPrettyPrint();

				format_tAFOX_1.setTrimText(false);
				format_tAFOX_1.setEncoding("UTF-8");

				final int[] orders_tAFOX_1 = new int[2];

				/**
				 * [tAdvancedFileOutputXML_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				int footer_tFileInputDelimited_1 = 0;
				int totalLinetFileInputDelimited_1 = 0;
				int limittFileInputDelimited_1 = -1;
				int lastLinetFileInputDelimited_1 = -1;

				char fieldSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_1 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_1 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_1 = /** Start field tFileInputDelimited_1:FILENAME */
						"C:/Users/Abdelhak Pedro/Downloads/Iris.csv"/** End field tFileInputDelimited_1:FILENAME */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_1 = null;

				try {

					String[] rowtFileInputDelimited_1 = null;
					int currentLinetFileInputDelimited_1 = 0;
					int outputLinetFileInputDelimited_1 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_1 = 0;
							if (footer_value_tFileInputDelimited_1 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_1,
									fieldSeparator_tFileInputDelimited_1[0], "US-ASCII");
						} else {
							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_1),
									fieldSeparator_tFileInputDelimited_1[0], "US-ASCII");
						}

						csvReadertFileInputDelimited_1.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
							csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

						csvReadertFileInputDelimited_1.setQuoteChar('"');

						csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						if (footer_tFileInputDelimited_1 > 0) {
							for (totalLinetFileInputDelimited_1 = 0; totalLinetFileInputDelimited_1 < 1; totalLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
							csvReadertFileInputDelimited_1.setSkipEmptyRecords(false);
							while (csvReadertFileInputDelimited_1.readNext()) {

								totalLinetFileInputDelimited_1++;

							}
							int lastLineTemptFileInputDelimited_1 = totalLinetFileInputDelimited_1
									- footer_tFileInputDelimited_1 < 0 ? 0
											: totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1;
							if (lastLinetFileInputDelimited_1 > 0) {
								lastLinetFileInputDelimited_1 = lastLinetFileInputDelimited_1 < lastLineTemptFileInputDelimited_1
										? lastLinetFileInputDelimited_1
										: lastLineTemptFileInputDelimited_1;
							} else {
								lastLinetFileInputDelimited_1 = lastLineTemptFileInputDelimited_1;
							}

							csvReadertFileInputDelimited_1.close();
							if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_1,
										fieldSeparator_tFileInputDelimited_1[0], "US-ASCII");
							} else {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_1),
										fieldSeparator_tFileInputDelimited_1[0], "US-ASCII");
							}
							csvReadertFileInputDelimited_1.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
								csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

							csvReadertFileInputDelimited_1.setQuoteChar('"');

							csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						}

						if (limittFileInputDelimited_1 != 0) {
							for (currentLinetFileInputDelimited_1 = 0; currentLinetFileInputDelimited_1 < 1; currentLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
						}
						csvReadertFileInputDelimited_1.setSkipEmptyRecords(false);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_1 != 0 && csvReadertFileInputDelimited_1 != null
							&& csvReadertFileInputDelimited_1.readNext()) {
						rowstate_tFileInputDelimited_1.reset();

						rowtFileInputDelimited_1 = csvReadertFileInputDelimited_1.getValues();

						currentLinetFileInputDelimited_1++;

						if (lastLinetFileInputDelimited_1 > -1
								&& currentLinetFileInputDelimited_1 > lastLinetFileInputDelimited_1) {
							break;
						}
						outputLinetFileInputDelimited_1++;
						if (limittFileInputDelimited_1 > 0
								&& outputLinetFileInputDelimited_1 > limittFileInputDelimited_1) {
							break;
						}

						row2 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row2 = new row2Struct();
						try {

							char fieldSeparator_tFileInputDelimited_1_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_1_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row2.Id = null;

								row2.SepalLengthCm = null;

								row2.SepalWidthCm = null;

								row2.PetalLengthCm = null;

								row2.PetalWidthCm = null;

								row2.Species = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_1 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_1 = 0;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									if (rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1].length() > 0) {
										try {

											row2.Id = ParserUtils.parseTo_Integer(
													rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1]);

										} catch (java.lang.Exception ex_tFileInputDelimited_1) {
											globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
													ex_tFileInputDelimited_1.getMessage());
											rowstate_tFileInputDelimited_1.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"Id", "row2",
															rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1],
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
										}
									} else {

										row2.Id = null;

									}

								} else {

									row2.Id = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 1;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									if (rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1].length() > 0) {
										try {

											row2.SepalLengthCm = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1]);

										} catch (java.lang.Exception ex_tFileInputDelimited_1) {
											globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
													ex_tFileInputDelimited_1.getMessage());
											rowstate_tFileInputDelimited_1.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"SepalLengthCm", "row2",
															rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1],
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
										}
									} else {

										row2.SepalLengthCm = null;

									}

								} else {

									row2.SepalLengthCm = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 2;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									if (rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1].length() > 0) {
										try {

											row2.SepalWidthCm = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1]);

										} catch (java.lang.Exception ex_tFileInputDelimited_1) {
											globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
													ex_tFileInputDelimited_1.getMessage());
											rowstate_tFileInputDelimited_1.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"SepalWidthCm", "row2",
															rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1],
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
										}
									} else {

										row2.SepalWidthCm = null;

									}

								} else {

									row2.SepalWidthCm = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 3;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									if (rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1].length() > 0) {
										try {

											row2.PetalLengthCm = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1]);

										} catch (java.lang.Exception ex_tFileInputDelimited_1) {
											globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
													ex_tFileInputDelimited_1.getMessage());
											rowstate_tFileInputDelimited_1.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"PetalLengthCm", "row2",
															rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1],
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
										}
									} else {

										row2.PetalLengthCm = null;

									}

								} else {

									row2.PetalLengthCm = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 4;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									if (rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1].length() > 0) {
										try {

											row2.PetalWidthCm = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1]);

										} catch (java.lang.Exception ex_tFileInputDelimited_1) {
											globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
													ex_tFileInputDelimited_1.getMessage());
											rowstate_tFileInputDelimited_1.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"PetalWidthCm", "row2",
															rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1],
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
										}
									} else {

										row2.PetalWidthCm = null;

									}

								} else {

									row2.PetalWidthCm = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 5;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row2.Species = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row2.Species = null;

								}

							}

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row2 = null;

							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row2"
						if (row2 != null) {
							row7 = null;

							/**
							 * [tAdvancedFileOutputXML_1 main ] start
							 */

							currentComponent = "tAdvancedFileOutputXML_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							nb_line_tAFOX_1++;
							valueMap_tAFOX_1.clear();
							valueMap_tAFOX_1.put("Id", (row2.Id != null ? row2.Id.toString() : null));
							valueMap_tAFOX_1.put("SepalLengthCm",
									(row2.SepalLengthCm != null ? row2.SepalLengthCm.toString() : null));
							valueMap_tAFOX_1.put("SepalWidthCm",
									(row2.SepalWidthCm != null ? row2.SepalWidthCm.toString() : null));
							valueMap_tAFOX_1.put("PetalLengthCm",
									(row2.PetalLengthCm != null ? row2.PetalLengthCm.toString() : null));
							valueMap_tAFOX_1.put("PetalWidthCm",
									(row2.PetalWidthCm != null ? row2.PetalWidthCm.toString() : null));
							valueMap_tAFOX_1.put("Species", (row2.Species != null ? row2.Species.toString() : null));

							org.dom4j.Element subTreeRootParent_tAFOX_1 = null;

							// build root xml tree
							if (needRoot_tAFOX_1) {
								needRoot_tAFOX_1 = false;
								if (orders_tAFOX_1.length > 0) {
									orders_tAFOX_1[0] = 0;
								}
								org.dom4j.Element root_tAFOX_1 = null;

								root_tAFOX_1 = doc_tAFOX_1.addElement("rootTag");

								subTreeRootParent_tAFOX_1 = root_tAFOX_1;
								root4Group_tAFOX_1 = subTreeRootParent_tAFOX_1;
							} else {

								subTreeRootParent_tAFOX_1 = root4Group_tAFOX_1;
							}
							// build group xml tree
							boolean isNewElememt_tAFOX_1 = false;
							if (isNewElememt_tAFOX_1 || groupbyList_tAFOX_1.size() <= 0
									|| groupbyList_tAFOX_1.get(0) == null
									|| (groupbyList_tAFOX_1.get(0).get(0) != null
											? !groupbyList_tAFOX_1.get(0).get(0).equals(valueMap_tAFOX_1.get("Id"))
											: valueMap_tAFOX_1.get("Id") != null)
									|| (groupbyList_tAFOX_1.get(0).get(1) != null
											? !groupbyList_tAFOX_1.get(0).get(1)
													.equals(valueMap_tAFOX_1.get("SepalLengthCm"))
											: valueMap_tAFOX_1.get("SepalLengthCm") != null)
									|| (groupbyList_tAFOX_1.get(0).get(2) != null
											? !groupbyList_tAFOX_1.get(0).get(2)
													.equals(valueMap_tAFOX_1.get("SepalWidthCm"))
											: valueMap_tAFOX_1.get("SepalWidthCm") != null)
									|| (groupbyList_tAFOX_1.get(0).get(3) != null
											? !groupbyList_tAFOX_1.get(0).get(3)
													.equals(valueMap_tAFOX_1.get("PetalLengthCm"))
											: valueMap_tAFOX_1.get("PetalLengthCm") != null)
									|| (groupbyList_tAFOX_1.get(0).get(4) != null
											? !groupbyList_tAFOX_1.get(0).get(4)
													.equals(valueMap_tAFOX_1.get("PetalWidthCm"))
											: valueMap_tAFOX_1.get("PetalWidthCm") != null)) {
								org.dom4j.Element group0__tAFOX_1 = null;

								group0__tAFOX_1 = org.dom4j.DocumentHelper.createElement("Flower");
								if (orders_tAFOX_1[0] == 0) {
									orders_tAFOX_1[0] = 0;
								}
								if (1 < orders_tAFOX_1.length) {
									orders_tAFOX_1[1] = 0;
								}
								subTreeRootParent_tAFOX_1.elements().add(orders_tAFOX_1[0]++, group0__tAFOX_1);

								subTreeRootParent_tAFOX_1 = group0__tAFOX_1;
								if (valueMap_tAFOX_1.get("Id") != null) {

									group0__tAFOX_1.addAttribute("Id", valueMap_tAFOX_1.get("Id"));
								}
								org.dom4j.Element group0__0_tAFOX_1 = null;

								group0__0_tAFOX_1 = group0__tAFOX_1.addElement("SepalLengthCm");
								if (valueMap_tAFOX_1.get("SepalLengthCm") != null) {
									nestXMLTool_tAFOX_1.setText(group0__0_tAFOX_1,
											valueMap_tAFOX_1.get("SepalLengthCm"));
								}
								org.dom4j.Element group0__1_tAFOX_1 = null;

								group0__1_tAFOX_1 = group0__tAFOX_1.addElement("SepalWidthCm");
								if (valueMap_tAFOX_1.get("SepalWidthCm") != null) {
									nestXMLTool_tAFOX_1.setText(group0__1_tAFOX_1,
											valueMap_tAFOX_1.get("SepalWidthCm"));
								}
								org.dom4j.Element group0__2_tAFOX_1 = null;

								group0__2_tAFOX_1 = group0__tAFOX_1.addElement("PetalLengthCm");
								if (valueMap_tAFOX_1.get("PetalLengthCm") != null) {
									nestXMLTool_tAFOX_1.setText(group0__2_tAFOX_1,
											valueMap_tAFOX_1.get("PetalLengthCm"));
								}
								org.dom4j.Element group0__3_tAFOX_1 = null;

								group0__3_tAFOX_1 = group0__tAFOX_1.addElement("PetalWidthCm");
								if (valueMap_tAFOX_1.get("PetalWidthCm") != null) {
									nestXMLTool_tAFOX_1.setText(group0__3_tAFOX_1,
											valueMap_tAFOX_1.get("PetalWidthCm"));
								}
								if (groupbyList_tAFOX_1.size() <= 0) {
									groupbyList_tAFOX_1.add(new java.util.ArrayList<String>());
								} else {
									groupbyList_tAFOX_1.get(0).clear();
								}
								groupbyList_tAFOX_1.get(0).add(valueMap_tAFOX_1.get("Id"));
								groupbyList_tAFOX_1.get(0).add(valueMap_tAFOX_1.get("SepalLengthCm"));
								groupbyList_tAFOX_1.get(0).add(valueMap_tAFOX_1.get("SepalWidthCm"));
								groupbyList_tAFOX_1.get(0).add(valueMap_tAFOX_1.get("PetalLengthCm"));
								groupbyList_tAFOX_1.get(0).add(valueMap_tAFOX_1.get("PetalWidthCm"));
								isNewElememt_tAFOX_1 = true;
								if (groupElementList_tAFOX_1.size() <= 0) {
									groupElementList_tAFOX_1.add(group0__tAFOX_1);
								} else {
									groupElementList_tAFOX_1.set(0, group0__tAFOX_1);
								}

							} else {

								subTreeRootParent_tAFOX_1 = groupElementList_tAFOX_1.get(0);
							}

							// build loop xml tree
							org.dom4j.Element loop_tAFOX_1 = null;

							loop_tAFOX_1 = org.dom4j.DocumentHelper.createElement("Species");
							if (orders_tAFOX_1[1] == 0) {
								orders_tAFOX_1[1] = 4;
							}
							if (2 < orders_tAFOX_1.length) {
								orders_tAFOX_1[2] = 0;
							}
							subTreeRootParent_tAFOX_1.elements().add(orders_tAFOX_1[1]++, loop_tAFOX_1);
							if (valueMap_tAFOX_1.get("Species") != null) {
								nestXMLTool_tAFOX_1.setText(loop_tAFOX_1, valueMap_tAFOX_1.get("Species"));
							}

							row3 = row2;

							tos_count_tAdvancedFileOutputXML_1++;

							/**
							 * [tAdvancedFileOutputXML_1 main ] stop
							 */

							/**
							 * [tAdvancedFileOutputXML_1 process_data_begin ] start
							 */

							currentComponent = "tAdvancedFileOutputXML_1";

							/**
							 * [tAdvancedFileOutputXML_1 process_data_begin ] stop
							 */

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_1 = false;
							boolean mainRowRejected_tMap_1 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row4"
							///////////////////////////////////////////////

							boolean forceLooprow4 = false;

							row4Struct row4ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								tHash_Lookup_row4.lookup(row4HashKey);

								if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

									forceLooprow4 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							else { // G 20 - G 21
								forceLooprow4 = true;
							} // G 21

							row4Struct row4 = null;

							while ((tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) || forceLooprow4) { // G_TM_M_043

								// CALL close loop of lookup 'row4'

								row4Struct fromLookup_row4 = null;
								row4 = row4Default;

								if (!forceLooprow4) { // G 46

									fromLookup_row4 = tHash_Lookup_row4.next();

									if (fromLookup_row4 != null) {
										row4 = fromLookup_row4;
									}

								} // G 46

								forceLooprow4 = false;

								try {// ###############################
									{ // start of Var scope

										// ###############################
										// # Vars tables

										Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
										// ###############################
										// # Output tables

										adding_type = null;

// # Output table : 'adding_type'
										adding_type_tmp.Id = row3.Id;
										adding_type_tmp.SepalLengthCm = row3.SepalLengthCm;
										adding_type_tmp.SepalWidthCm = row3.SepalWidthCm;
										adding_type_tmp.PetalLengthCm = row3.PetalLengthCm;
										adding_type_tmp.PetalWidthCm = row3.PetalWidthCm;
										adding_type_tmp.Species = row3.Species;
										adding_type_tmp.type = row4.type;
										adding_type = adding_type_tmp;
// ###############################

									} // end of Var scope

									rejectedInnerJoin_tMap_1 = false;

								} catch (java.lang.Exception e) {
									// if anohter java.lang.Exception when processing an java.lang.Exception

									try {// EE
										Var__tMap_1__Struct Var = Var__tMap_1;

										adding_type = null;
									} catch (java.lang.Exception ee) {// EE

										ee.printStackTrace();
										adding_type = null;
									} // EE
								} // end catch

								tos_count_tMap_1++;

								/**
								 * [tMap_1 main ] stop
								 */

								/**
								 * [tMap_1 process_data_begin ] start
								 */

								currentComponent = "tMap_1";

								/**
								 * [tMap_1 process_data_begin ] stop
								 */
// Start of branch "adding_type"
								if (adding_type != null) {
									row7 = null;

									/**
									 * [tFileOutputDelimited_1 main ] start
									 */

									currentComponent = "tFileOutputDelimited_1";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "adding_type"

										);
									}

									String[] rowtFileOutputDelimited_1 = new String[7];
									rowtFileOutputDelimited_1[0] = adding_type.Id == null ? null
											: String.valueOf(adding_type.Id);
									rowtFileOutputDelimited_1[1] = adding_type.SepalLengthCm == null ? null
											: String.valueOf(adding_type.SepalLengthCm);
									rowtFileOutputDelimited_1[2] = adding_type.SepalWidthCm == null ? null
											: String.valueOf(adding_type.SepalWidthCm);
									rowtFileOutputDelimited_1[3] = adding_type.PetalLengthCm == null ? null
											: String.valueOf(adding_type.PetalLengthCm);
									rowtFileOutputDelimited_1[4] = adding_type.PetalWidthCm == null ? null
											: String.valueOf(adding_type.PetalWidthCm);
									rowtFileOutputDelimited_1[5] = adding_type.Species == null ? null
											: adding_type.Species;
									rowtFileOutputDelimited_1[6] = adding_type.type == null ? null : adding_type.type;
									nb_line_tFileOutputDelimited_1++;
									resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);
									CsvWritertFileOutputDelimited_1.writeNext(rowtFileOutputDelimited_1);

									row5 = adding_type;

									tos_count_tFileOutputDelimited_1++;

									/**
									 * [tFileOutputDelimited_1 main ] stop
									 */

									/**
									 * [tFileOutputDelimited_1 process_data_begin ] start
									 */

									currentComponent = "tFileOutputDelimited_1";

									/**
									 * [tFileOutputDelimited_1 process_data_begin ] stop
									 */

									/**
									 * [tFilterRow_1 main ] start
									 */

									currentComponent = "tFilterRow_1";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "row5"

										);
									}

									row7 = null;
									row6 = null;
									Operator_tFilterRow_1 ope_tFilterRow_1 = new Operator_tFilterRow_1("&&");
									ope_tFilterRow_1
											.matches(
													(row5.SepalWidthCm == null ? false
															: row5.SepalWidthCm.compareTo(ParserUtils
																	.parseTo_Float(String.valueOf(4.0))) >= 0),
													"SepalWidthCm.compareTo(4.0) >= 0 failed");

									if (ope_tFilterRow_1.getMatchFlag()) {
										if (row6 == null) {
											row6 = new row6Struct();
										}
										row6.Id = row5.Id;
										row6.SepalLengthCm = row5.SepalLengthCm;
										row6.SepalWidthCm = row5.SepalWidthCm;
										row6.PetalLengthCm = row5.PetalLengthCm;
										row6.PetalWidthCm = row5.PetalWidthCm;
										row6.Species = row5.Species;
										row6.type = row5.type;
										nb_line_ok_tFilterRow_1++;
									} else {
										if (row7 == null) {
											row7 = new row7Struct();
										}
										row7.Id = row5.Id;
										row7.SepalLengthCm = row5.SepalLengthCm;
										row7.SepalWidthCm = row5.SepalWidthCm;
										row7.PetalLengthCm = row5.PetalLengthCm;
										row7.PetalWidthCm = row5.PetalWidthCm;
										row7.Species = row5.Species;
										row7.type = row5.type;
										row7.errorMessage = ope_tFilterRow_1.getErrorMsg();
										nb_line_reject_tFilterRow_1++;
									}

									nb_line_tFilterRow_1++;

									tos_count_tFilterRow_1++;

									/**
									 * [tFilterRow_1 main ] stop
									 */

									/**
									 * [tFilterRow_1 process_data_begin ] start
									 */

									currentComponent = "tFilterRow_1";

									/**
									 * [tFilterRow_1 process_data_begin ] stop
									 */
// Start of branch "row6"
									if (row6 != null) {

										/**
										 * [tFileOutputDelimited_2 main ] start
										 */

										currentComponent = "tFileOutputDelimited_2";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "row6"

											);
										}

										String[] rowtFileOutputDelimited_2 = new String[7];
										rowtFileOutputDelimited_2[0] = row6.Id == null ? null : String.valueOf(row6.Id);
										rowtFileOutputDelimited_2[1] = row6.SepalLengthCm == null ? null
												: String.valueOf(row6.SepalLengthCm);
										rowtFileOutputDelimited_2[2] = row6.SepalWidthCm == null ? null
												: String.valueOf(row6.SepalWidthCm);
										rowtFileOutputDelimited_2[3] = row6.PetalLengthCm == null ? null
												: String.valueOf(row6.PetalLengthCm);
										rowtFileOutputDelimited_2[4] = row6.PetalWidthCm == null ? null
												: String.valueOf(row6.PetalWidthCm);
										rowtFileOutputDelimited_2[5] = row6.Species == null ? null : row6.Species;
										rowtFileOutputDelimited_2[6] = row6.type == null ? null : row6.type;
										nb_line_tFileOutputDelimited_2++;
										resourceMap.put("nb_line_tFileOutputDelimited_2",
												nb_line_tFileOutputDelimited_2);
										CsvWritertFileOutputDelimited_2.writeNext(rowtFileOutputDelimited_2);

										tos_count_tFileOutputDelimited_2++;

										/**
										 * [tFileOutputDelimited_2 main ] stop
										 */

										/**
										 * [tFileOutputDelimited_2 process_data_begin ] start
										 */

										currentComponent = "tFileOutputDelimited_2";

										/**
										 * [tFileOutputDelimited_2 process_data_begin ] stop
										 */

										/**
										 * [tFileOutputDelimited_2 process_data_end ] start
										 */

										currentComponent = "tFileOutputDelimited_2";

										/**
										 * [tFileOutputDelimited_2 process_data_end ] stop
										 */

									} // End of branch "row6"

// Start of branch "row7"
									if (row7 != null) {

										/**
										 * [tFileOutputDelimited_3 main ] start
										 */

										currentComponent = "tFileOutputDelimited_3";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "row7"

											);
										}

										String[] rowtFileOutputDelimited_3 = new String[7];
										rowtFileOutputDelimited_3[0] = row7.Id == null ? null : String.valueOf(row7.Id);
										rowtFileOutputDelimited_3[1] = row7.SepalLengthCm == null ? null
												: String.valueOf(row7.SepalLengthCm);
										rowtFileOutputDelimited_3[2] = row7.SepalWidthCm == null ? null
												: String.valueOf(row7.SepalWidthCm);
										rowtFileOutputDelimited_3[3] = row7.PetalLengthCm == null ? null
												: String.valueOf(row7.PetalLengthCm);
										rowtFileOutputDelimited_3[4] = row7.PetalWidthCm == null ? null
												: String.valueOf(row7.PetalWidthCm);
										rowtFileOutputDelimited_3[5] = row7.Species == null ? null : row7.Species;
										rowtFileOutputDelimited_3[6] = row7.type == null ? null : row7.type;
										nb_line_tFileOutputDelimited_3++;
										resourceMap.put("nb_line_tFileOutputDelimited_3",
												nb_line_tFileOutputDelimited_3);
										CsvWritertFileOutputDelimited_3.writeNext(rowtFileOutputDelimited_3);

										tos_count_tFileOutputDelimited_3++;

										/**
										 * [tFileOutputDelimited_3 main ] stop
										 */

										/**
										 * [tFileOutputDelimited_3 process_data_begin ] start
										 */

										currentComponent = "tFileOutputDelimited_3";

										/**
										 * [tFileOutputDelimited_3 process_data_begin ] stop
										 */

										/**
										 * [tFileOutputDelimited_3 process_data_end ] start
										 */

										currentComponent = "tFileOutputDelimited_3";

										/**
										 * [tFileOutputDelimited_3 process_data_end ] stop
										 */

									} // End of branch "row7"

									/**
									 * [tFilterRow_1 process_data_end ] start
									 */

									currentComponent = "tFilterRow_1";

									/**
									 * [tFilterRow_1 process_data_end ] stop
									 */

									/**
									 * [tFileOutputDelimited_1 process_data_end ] start
									 */

									currentComponent = "tFileOutputDelimited_1";

									/**
									 * [tFileOutputDelimited_1 process_data_end ] stop
									 */

								} // End of branch "adding_type"

							} // close loop of lookup 'row4' // G_TM_M_043

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

							/**
							 * [tAdvancedFileOutputXML_1 process_data_end ] start
							 */

							currentComponent = "tAdvancedFileOutputXML_1";

							/**
							 * [tAdvancedFileOutputXML_1 process_data_end ] stop
							 */

						} // End of branch "row2"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						nb_line_tFileInputDelimited_1++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_1 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_1 != null) {
							csvReadertFileInputDelimited_1.close();
						}
					}
					if (csvReadertFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", nb_line_tFileInputDelimited_1);
					}

				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tAdvancedFileOutputXML_1 end ] start
				 */

				currentComponent = "tAdvancedFileOutputXML_1";

				nameToElement_tAFOX_1.clear();
				java.io.FileOutputStream stream_tAFOX_1 = new java.io.FileOutputStream(fileName_tAFOX_1);
				org.dom4j.io.XMLWriter output_tAFOX_1 = new org.dom4j.io.XMLWriter(stream_tAFOX_1, format_tAFOX_1);
				if (doc_tAFOX_1.getRootElement() != null) {
					nestXMLTool_tAFOX_1.replaceDefaultNameSpace(doc_tAFOX_1.getRootElement());
					nestXMLTool_tAFOX_1.removeWhiteSpaceTextNode(doc_tAFOX_1.getRootElement());
					output_tAFOX_1.write(doc_tAFOX_1);
				}
				output_tAFOX_1.close();
				globalMap.put("tAdvancedFileOutputXML_1_NB_LINE", nb_line_tAFOX_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tAdvancedFileOutputXML_1", true);
				end_Hash.put("tAdvancedFileOutputXML_1", System.currentTimeMillis());

				/**
				 * [tAdvancedFileOutputXML_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 end ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (CsvWritertFileOutputDelimited_1 != null) {
					CsvWritertFileOutputDelimited_1.close();
				}

				globalMap.put("tFileOutputDelimited_1_NB_LINE", nb_line_tFileOutputDelimited_1);

				resourceMap.put("finish_tFileOutputDelimited_1", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "adding_type");
				}

				ok_Hash.put("tFileOutputDelimited_1", true);
				end_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_1 end ] stop
				 */

				/**
				 * [tFilterRow_1 end ] start
				 */

				currentComponent = "tFilterRow_1";

				globalMap.put("tFilterRow_1_NB_LINE", nb_line_tFilterRow_1);
				globalMap.put("tFilterRow_1_NB_LINE_OK", nb_line_ok_tFilterRow_1);
				globalMap.put("tFilterRow_1_NB_LINE_REJECT", nb_line_reject_tFilterRow_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tFilterRow_1", true);
				end_Hash.put("tFilterRow_1", System.currentTimeMillis());

				/**
				 * [tFilterRow_1 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 end ] start
				 */

				currentComponent = "tFileOutputDelimited_2";

				if (CsvWritertFileOutputDelimited_2 != null) {
					CsvWritertFileOutputDelimited_2.close();
				}

				globalMap.put("tFileOutputDelimited_2_NB_LINE", nb_line_tFileOutputDelimited_2);

				resourceMap.put("finish_tFileOutputDelimited_2", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tFileOutputDelimited_2", true);
				end_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_2 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 end ] start
				 */

				currentComponent = "tFileOutputDelimited_3";

				if (CsvWritertFileOutputDelimited_3 != null) {
					CsvWritertFileOutputDelimited_3.close();
				}

				globalMap.put("tFileOutputDelimited_3_NB_LINE", nb_line_tFileOutputDelimited_3);

				resourceMap.put("finish_tFileOutputDelimited_3", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
				}

				ok_Hash.put("tFileOutputDelimited_3", true);
				end_Hash.put("tFileOutputDelimited_3", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_3 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_1:OnSubjobOk1", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tJava_1Process(globalMap);

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_1:OnSubjobOk2", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
			}

			tMsgBox_1Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row4");

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tAdvancedFileOutputXML_1 finally ] start
				 */

				currentComponent = "tAdvancedFileOutputXML_1";

				/**
				 * [tAdvancedFileOutputXML_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (resourceMap.get("finish_tFileOutputDelimited_1") == null) {

					com.talend.csv.CSVWriter CsvWritertFileOutputDelimited_1 = (com.talend.csv.CSVWriter) resourceMap
							.get("CsvWriter_tFileOutputDelimited_1");

					if (CsvWritertFileOutputDelimited_1 != null) {
						CsvWritertFileOutputDelimited_1.close();
					}

				}

				/**
				 * [tFileOutputDelimited_1 finally ] stop
				 */

				/**
				 * [tFilterRow_1 finally ] start
				 */

				currentComponent = "tFilterRow_1";

				/**
				 * [tFilterRow_1 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_2";

				if (resourceMap.get("finish_tFileOutputDelimited_2") == null) {

					com.talend.csv.CSVWriter CsvWritertFileOutputDelimited_2 = (com.talend.csv.CSVWriter) resourceMap
							.get("CsvWriter_tFileOutputDelimited_2");

					if (CsvWritertFileOutputDelimited_2 != null) {
						CsvWritertFileOutputDelimited_2.close();
					}

				}

				/**
				 * [tFileOutputDelimited_2 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_3";

				if (resourceMap.get("finish_tFileOutputDelimited_3") == null) {

					com.talend.csv.CSVWriter CsvWritertFileOutputDelimited_3 = (com.talend.csv.CSVWriter) resourceMap
							.get("CsvWriter_tFileOutputDelimited_3");

					if (CsvWritertFileOutputDelimited_3 != null) {
						CsvWritertFileOutputDelimited_3.close();
					}

				}

				/**
				 * [tFileOutputDelimited_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tJava_1 begin ] start
				 */

				ok_Hash.put("tJava_1", false);
				start_Hash.put("tJava_1", System.currentTimeMillis());

				currentComponent = "tJava_1";

				int tos_count_tJava_1 = 0;

				System.out.println("The job is well executed :)");

				/**
				 * [tJava_1 begin ] stop
				 */

				/**
				 * [tJava_1 main ] start
				 */

				currentComponent = "tJava_1";

				tos_count_tJava_1++;

				/**
				 * [tJava_1 main ] stop
				 */

				/**
				 * [tJava_1 process_data_begin ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_begin ] stop
				 */

				/**
				 * [tJava_1 process_data_end ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_end ] stop
				 */

				/**
				 * [tJava_1 end ] start
				 */

				currentComponent = "tJava_1";

				ok_Hash.put("tJava_1", true);
				end_Hash.put("tJava_1", System.currentTimeMillis());

				/**
				 * [tJava_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tJava_1 finally ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}

	public void tMsgBox_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tMsgBox_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tMsgBox_1 begin ] start
				 */

				ok_Hash.put("tMsgBox_1", false);
				start_Hash.put("tMsgBox_1", System.currentTimeMillis());

				currentComponent = "tMsgBox_1";

				int tos_count_tMsgBox_1 = 0;

				/**
				 * [tMsgBox_1 begin ] stop
				 */

				/**
				 * [tMsgBox_1 main ] start
				 */

				currentComponent = "tMsgBox_1";

				int messageIcontMsgBox_1 = javax.swing.JOptionPane.INFORMATION_MESSAGE;
				String titletMsgBox_1 = "Environnement de travail";
				String messagetMsgBox_1 = "Attention vous êtes de l'environnement " + context.ENV;
				String resulttMsgBox_1 = null;

				javax.swing.JOptionPane.showMessageDialog(null, messagetMsgBox_1, titletMsgBox_1, messageIcontMsgBox_1);
				resulttMsgBox_1 = String.valueOf(1);

				globalMap.put("tMsgBox_1_RESULT", resulttMsgBox_1);

				tos_count_tMsgBox_1++;

				/**
				 * [tMsgBox_1 main ] stop
				 */

				/**
				 * [tMsgBox_1 process_data_begin ] start
				 */

				currentComponent = "tMsgBox_1";

				/**
				 * [tMsgBox_1 process_data_begin ] stop
				 */

				/**
				 * [tMsgBox_1 process_data_end ] start
				 */

				currentComponent = "tMsgBox_1";

				/**
				 * [tMsgBox_1 process_data_end ] stop
				 */

				/**
				 * [tMsgBox_1 end ] start
				 */

				currentComponent = "tMsgBox_1";

				ok_Hash.put("tMsgBox_1", true);
				end_Hash.put("tMsgBox_1", System.currentTimeMillis());

				/**
				 * [tMsgBox_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tMsgBox_1 finally ] start
				 */

				currentComponent = "tMsgBox_1";

				/**
				 * [tMsgBox_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tMsgBox_1_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_TEST_PROJECT_Job_types_connexions = new byte[0];
		static byte[] commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[0];

		public String type;

		public String getType() {
			return this.type;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_PROJECT_Job_types_connexions.length) {
					if (length < 1024 && commonByteArray_TEST_PROJECT_Job_types_connexions.length == 0) {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[1024];
					} else {
						commonByteArray_TEST_PROJECT_Job_types_connexions = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length);
				strReturn = new String(commonByteArray_TEST_PROJECT_Job_types_connexions, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TEST_PROJECT_Job_types_connexions) {

				try {

					int length = 0;

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("type=" + type);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tFileInputDelimited_2 - inputs:(after_tFileInputDelimited_1)
				// outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4)
				// outputs:()
				// linked node: tMap_1 - inputs:(row3,row4) outputs:(adding_type)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_2", false);
				start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_2";

				int tos_count_tFileInputDelimited_2 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_2 = 0;
				int footer_tFileInputDelimited_2 = 0;
				int totalLinetFileInputDelimited_2 = 0;
				int limittFileInputDelimited_2 = -1;
				int lastLinetFileInputDelimited_2 = -1;

				char fieldSeparator_tFileInputDelimited_2[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_2 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_2[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_2 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_2 = /** Start field tFileInputDelimited_2:FILENAME */
						"C:/Users/Abdelhak Pedro/Documents/Talend/In/input.csv"/**
																				 * End field
																				 * tFileInputDelimited_2:FILENAME
																				 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_2 = null;

				try {

					String[] rowtFileInputDelimited_2 = null;
					int currentLinetFileInputDelimited_2 = 0;
					int outputLinetFileInputDelimited_2 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_2 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_2 = 0;
							if (footer_value_tFileInputDelimited_2 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_2 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_2,
									fieldSeparator_tFileInputDelimited_2[0], "US-ASCII");
						} else {
							csvReadertFileInputDelimited_2 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_2),
									fieldSeparator_tFileInputDelimited_2[0], "US-ASCII");
						}

						csvReadertFileInputDelimited_2.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_2[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_2[0] != '\r'))
							csvReadertFileInputDelimited_2.setLineEnd("" + rowSeparator_tFileInputDelimited_2[0]);

						csvReadertFileInputDelimited_2.setQuoteChar('"');

						csvReadertFileInputDelimited_2.setEscapeChar(csvReadertFileInputDelimited_2.getQuoteChar());

						if (footer_tFileInputDelimited_2 > 0) {
							for (totalLinetFileInputDelimited_2 = 0; totalLinetFileInputDelimited_2 < 1; totalLinetFileInputDelimited_2++) {
								csvReadertFileInputDelimited_2.readNext();
							}
							csvReadertFileInputDelimited_2.setSkipEmptyRecords(false);
							while (csvReadertFileInputDelimited_2.readNext()) {

								totalLinetFileInputDelimited_2++;

							}
							int lastLineTemptFileInputDelimited_2 = totalLinetFileInputDelimited_2
									- footer_tFileInputDelimited_2 < 0 ? 0
											: totalLinetFileInputDelimited_2 - footer_tFileInputDelimited_2;
							if (lastLinetFileInputDelimited_2 > 0) {
								lastLinetFileInputDelimited_2 = lastLinetFileInputDelimited_2 < lastLineTemptFileInputDelimited_2
										? lastLinetFileInputDelimited_2
										: lastLineTemptFileInputDelimited_2;
							} else {
								lastLinetFileInputDelimited_2 = lastLineTemptFileInputDelimited_2;
							}

							csvReadertFileInputDelimited_2.close();
							if (filename_tFileInputDelimited_2 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_2 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_2,
										fieldSeparator_tFileInputDelimited_2[0], "US-ASCII");
							} else {
								csvReadertFileInputDelimited_2 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_2),
										fieldSeparator_tFileInputDelimited_2[0], "US-ASCII");
							}
							csvReadertFileInputDelimited_2.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_2[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_2[0] != '\r'))
								csvReadertFileInputDelimited_2.setLineEnd("" + rowSeparator_tFileInputDelimited_2[0]);

							csvReadertFileInputDelimited_2.setQuoteChar('"');

							csvReadertFileInputDelimited_2.setEscapeChar(csvReadertFileInputDelimited_2.getQuoteChar());

						}

						if (limittFileInputDelimited_2 != 0) {
							for (currentLinetFileInputDelimited_2 = 0; currentLinetFileInputDelimited_2 < 1; currentLinetFileInputDelimited_2++) {
								csvReadertFileInputDelimited_2.readNext();
							}
						}
						csvReadertFileInputDelimited_2.setSkipEmptyRecords(false);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_2 != 0 && csvReadertFileInputDelimited_2 != null
							&& csvReadertFileInputDelimited_2.readNext()) {
						rowstate_tFileInputDelimited_2.reset();

						rowtFileInputDelimited_2 = csvReadertFileInputDelimited_2.getValues();

						currentLinetFileInputDelimited_2++;

						if (lastLinetFileInputDelimited_2 > -1
								&& currentLinetFileInputDelimited_2 > lastLinetFileInputDelimited_2) {
							break;
						}
						outputLinetFileInputDelimited_2++;
						if (limittFileInputDelimited_2 > 0
								&& outputLinetFileInputDelimited_2 > limittFileInputDelimited_2) {
							break;
						}

						row4 = null;

						row4 = null;

						boolean whetherReject_tFileInputDelimited_2 = false;
						row4 = new row4Struct();
						try {

							char fieldSeparator_tFileInputDelimited_2_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_2_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_2.length == 1 && ("\015").equals(rowtFileInputDelimited_2[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row4.type = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_2 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_2 = 0;

								if (columnIndexWithD_tFileInputDelimited_2 < rowtFileInputDelimited_2.length) {

									row4.type = rowtFileInputDelimited_2[columnIndexWithD_tFileInputDelimited_2];

								} else {

									row4.type = null;

								}

							}

							if (rowstate_tFileInputDelimited_2.getException() != null) {
								throw rowstate_tFileInputDelimited_2.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_2 = true;

							System.err.println(e.getMessage());
							row4 = null;

							globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_2 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_2 main ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						tos_count_tFileInputDelimited_2++;

						/**
						 * [tFileInputDelimited_2 main ] stop
						 */

						/**
						 * [tFileInputDelimited_2 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_begin ] stop
						 */
// Start of branch "row4"
						if (row4 != null) {

							/**
							 * [tAdvancedHash_row4 main ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row4"

								);
							}

							row4Struct row4_HashRow = new row4Struct();

							row4_HashRow.type = row4.type;

							tHash_Lookup_row4.put(row4_HashRow);

							tos_count_tAdvancedHash_row4++;

							/**
							 * [tAdvancedHash_row4 main ] stop
							 */

							/**
							 * [tAdvancedHash_row4 process_data_begin ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							/**
							 * [tAdvancedHash_row4 process_data_begin ] stop
							 */

							/**
							 * [tAdvancedHash_row4 process_data_end ] start
							 */

							currentComponent = "tAdvancedHash_row4";

							/**
							 * [tAdvancedHash_row4 process_data_end ] stop
							 */

						} // End of branch "row4"

						/**
						 * [tFileInputDelimited_2 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_2 end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						nb_line_tFileInputDelimited_2++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_2 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_2 != null) {
							csvReadertFileInputDelimited_2.close();
						}
					}
					if (csvReadertFileInputDelimited_2 != null) {
						globalMap.put("tFileInputDelimited_2_NB_LINE", nb_line_tFileInputDelimited_2);
					}

				}

				ok_Hash.put("tFileInputDelimited_2", true);
				end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_2 finally ] start
				 */

				currentComponent = "tFileInputDelimited_2";

				/**
				 * [tFileInputDelimited_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "PREPROD";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Job_types_connexions Job_types_connexionsClass = new Job_types_connexions();

		int exitCode = Job_types_connexionsClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Job_types_connexions.class.getClassLoader().getResourceAsStream(
					"test_project/job_types_connexions_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Job_types_connexions.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("ENV", "id_String");
					if (context.getStringValue("ENV") == null) {
						context.ENV = null;
					} else {
						context.ENV = (String) context.getProperty("ENV");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("ENV")) {
				context.ENV = (String) parentContextMap.get("ENV");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job_types_connexions");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 213520 characters generated by Talend Open Studio for Data Integration on the
 * 23 décembre 2022 à 21:13:18 GMT+01:00
 ************************************************************************************************/