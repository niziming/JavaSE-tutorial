package chap11.demo03;

public class Role implements FaShuSkill{
    FaShuSkill fs;
    public void setFaShuSkill() {
        this.fs = fs;
    }
    public void faShuSkillAttack (String tpye) {
        System.out.println("发动法术攻击:");
        // fs.faShuAttack("类型");
        faShuAttack(tpye);
        System.out.println("攻击完毕");
    }

    @Override
    public void faShuAttack(String type) {
        System.out.println("发动 " + type + " 攻击");
    }
}
