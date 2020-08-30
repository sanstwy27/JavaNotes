package sanstwy27.bean;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Monster {
    private Integer id = 10;
    private String nickname = "Princess Iron-Fan";
    private String skill = "Palm-leaf fan";

    public Monster() {
        System.out.println("monster created..");
    }

    public Monster(Integer id, String nickname, String skill) {
        this.id = id;
        this.nickname = nickname;
        this.skill = skill;
    }

    public Monster(String nickname, String skill, Integer id) {

        this.id = id;
        this.nickname = nickname;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Monster [id=" + id + ", nickname=" + nickname + ", skill="
                + skill + "]";
    }
}
