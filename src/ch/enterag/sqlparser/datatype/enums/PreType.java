package ch.enterag.sqlparser.datatype.enums;
import java.sql.*;
import ch.enterag.sqlparser.*;
public enum PreType
{
  CHAR(Types.CHAR, K.CHARACTER.getKeyword()),
  VARCHAR(Types.VARCHAR, K.VARCHAR.getKeyword()),
  CLOB(Types.CLOB, K.CLOB.getKeyword()),
  NCHAR(Types.NCHAR, K.NCHAR.getKeyword()),
  NVARCHAR(Types.NVARCHAR, K.NCHAR.getKeyword()+" "+K.VARYING.getKeyword()),
  NCLOB(Types.NCLOB, K.NCLOB.getKeyword()),
  BINARY(Types.BINARY, K.BINARY.getKeyword()),
  VARBINARY(Types.VARBINARY, K.VARBINARY.getKeyword()),
  BLOB(Types.BLOB, K.BLOB.getKeyword()),
  NUMERIC(Types.NUMERIC, K.NUMERIC.getKeyword()),
  DECIMAL(Types.DECIMAL, K.DECIMAL.getKeyword()),
  SMALLINT(Types.SMALLINT, K.SMALLINT.getKeyword()),
  INTEGER(Types.INTEGER, K.INTEGER.getKeyword()),
  BIGINT(Types.BIGINT, K.BIGINT.getKeyword()),
  FLOAT(Types.FLOAT, K.FLOAT.getKeyword()),
  REAL(Types.REAL, K.REAL.getKeyword()),
  DOUBLE(Types.DOUBLE, K.DOUBLE.getKeyword()+" "+K.PRECISION.getKeyword()),
  BOOLEAN(Types.BOOLEAN, K.BOOLEAN.getKeyword()),
  DATE(Types.DATE, K.DATE.getKeyword()),
  TIME(Types.TIME, K.TIME.getKeyword()),
  TIMESTAMP(Types.TIMESTAMP, K.TIMESTAMP.getKeyword()),
  XML(Types.SQLXML, K.XML.getKeyword()),
  INTERVAL(Types.OTHER, K.INTERVAL.getKeyword()); // INTERVAL not supported by JDBC!
  private String _sKeyword = null;
  public String getKeyword() { return _sKeyword; }
  private int _iSqlType = Types.NULL;
  public int getSqlType() { return _iSqlType; }
  private PreType(int iSqlType, String sKeyword)
  {
    _iSqlType = iSqlType;
    _sKeyword = sKeyword;
  } /* constructor */
  public static PreType getBySqlType(int iSqlType)
  {
    PreType datatype  = null;
    for (int i = 0; (datatype == null) && (i < PreType.values().length); i++)
    {
      PreType dt = PreType.values()[i];
      if (dt.getSqlType() == iSqlType)
        datatype = dt;
    }
    return datatype;
  } /* getBySqlType */
  
}
