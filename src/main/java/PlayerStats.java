public class PlayerStats {
    int happiness; // affects demeanor
    int stress; // affects sleep
    int tiredness; // affects attack and defense
    int toxicity; // affects charisma
    Boolean alive;
    Integer health;
    String playerName;
    int attack; 
    int defense;

    // Constructor
    public PlayerStats(Integer happiness, Integer stress, Integer tiredness, Integer toxicity, Boolean alive, Integer health, Integer attack, String playerName) {
        this.happiness = happiness;
        this.stress = stress;
        this.tiredness = tiredness;
        this.toxicity = toxicity;
        this.alive = alive;
        this.health = health;
        this.playerName = playerName;
        this.attack = attack;
    }

    
    public Integer getHappiness() {
        return happiness;
    }

    public Integer getStress() {
        return stress;
    }

    public Integer getTiredness() {
        return tiredness;
    }
    public void setTiredness(int tiredness) {
        if (tiredness < 0) {
            this.tiredness = 0;
        } else if (tiredness > 100) {
            this.tiredness = 100;
        } else {
            this.tiredness = tiredness;
        }
    }

    public Integer getToxicity() {
        return toxicity;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getPlayerHealth() {
        return health;
    }

    public Boolean isAlive() {
        return alive;
    }
    public Integer getAttack() {
        return attack;
    }

    
    public void setPlayerAlive(Boolean alive) {
        this.alive = alive;
    }
}
