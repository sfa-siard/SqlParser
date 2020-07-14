package ch.enterag.sqlparser.expression.enums;
public enum AdditiveOperator
{
  PLUS_SIGN("+"),
  MINUS_SIGN("-");
  private String _sKeywords = null;
  public String getKeywords() { return _sKeywords; }
  private AdditiveOperator(String sKeywords) { _sKeywords = sKeywords; }
}
