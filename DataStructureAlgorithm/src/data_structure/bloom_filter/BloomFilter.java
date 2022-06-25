package data_structure.bloom_filter;

import lombok.Data;

import java.util.BitSet;

/**
 * 布隆过滤器
 * @author 十渊
 * 引用JavaGuide
 */
@Data
public class BloomFilter {
  /**
   * 位数组大小 2左移24位 = 2^24
   */
  private static final int DEFAULT_SIZE = 2 << 24;

  /**
   * 通过这个数组可以创建 6 个不同的哈希函数
   */
  private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

  /**
   * 位数组。数组中的元素只能是 0 或者 1
   */
  private BitSet bits = new BitSet(DEFAULT_SIZE);

  /**
   * 存放包含 hash 函数的类的数组
   */
  private SimpleHash[] func = new SimpleHash[SEEDS.length];
  /**
   * 初始化多个包含 hash 函数的类的数组，每个类中的 hash 函数都不一样
   */
  public BloomFilter() {
    // 初始化多个不同的 Hash 函数
    for (int i = 0; i < SEEDS.length; i++) {
      func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
    }
  }


  /**
   * 添加元素到位数组
   */
  public void add(Object value) {
    for (SimpleHash f : func) {
      bits.set(f.hash(value), true);
    }
  }

  /**
   * 判断指定元素是否存在于位数组
   */
  public boolean contains(Object value) {
    boolean ret = true;
    for (SimpleHash f : func) {
      ret = ret && bits.get(f.hash(value));
    }
    return ret;
  }

  /**
   * 静态内部类。用于 hash 操作！
   */
  public static class SimpleHash {

    private int cap;
    private int seed;

    public SimpleHash(int cap, int seed) {
      this.cap = cap;
      this.seed = seed;
    }

    /**
     * 计算 hash 值
     */
    public int hash(Object value) {
      int h;
      return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
    }

  }

  public static void main(String[] args) {
    // String value1 = "https://javaguide.cn/";
    // String value2 = "https://github.com/Snailclimb";
    // BloomFilter filter = new BloomFilter();
    // System.out.println(filter.contains(value1));
    // System.out.println(filter.contains(value2));
    // filter.add(value1);
    // filter.add(value2);
    // System.out.println(filter.contains(value1));
    // System.out.println(filter.contains(value2));
    //
    // System.out.println(filter);
    System.out.println(66 >> 1);
    System.out.println(-66 >> 2);
    System.out.println(100 >> 2);
    System.out.println(66 >>> 1);
    System.out.println(-66 >>> 2);
  }

}
