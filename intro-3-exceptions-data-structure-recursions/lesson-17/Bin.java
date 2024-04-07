public class Bin {
  private Object content;

  public Bin(Object content) {
    this.content = content;
  }

  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }

  public static void main(String[] args) {
    String[] nums = new String[5];
    for (String num : nums) {
      System.out.println(num.toUpperCase());
    }
  }
}
