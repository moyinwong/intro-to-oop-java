
public class Wolf implements Comparable<Wolf> {
  int rank;

  @Override
  public int compareTo(Wolf o) {
    // TODO Auto-generated method stub
    return -(rank - ((Wolf) o).rank);
  }

}