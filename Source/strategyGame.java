abstract class FightUnity{
    protected int lifePoints;
    public abstract void getDamage(int damagePoints);
    public abstract void hit(FightUnity unity);
    public abstract boolean isAlive();
    public abstract String toString();
}
class Archer extends FightUnity{
    public Archer(int lifePoints){
        this.lifePoints = lifePoints;
    }
    @Override
    public boolean isAlive(){
        if(this.lifePoints > 0)
            return true;
        else
            return false;
    }
    @Override
    public void getDamage(int damagePoints){
        if(this.isAlive())
            this.lifePoints -= damagePoints;
    }
    @Override
    public void hit(FightUnity unity){
        if(this.isAlive()){
            unity.getDamage(10);
        }
    }
    @Override
    public String toString(){
        return "Archer: lifePoints = " + this.lifePoints;
    }
}
class Rider extends FightUnity{
    public Rider(int lifePoints){
        this.lifePoints = lifePoints;
    }
    @Override
    public boolean isAlive(){
        if(this.lifePoints > 0)
            return true;
        else
            return false;
    }
    @Override
    public void getDamage(int damagePoints){
        if(this.isAlive())
            this.lifePoints -= damagePoints;
    }
    @Override
    public void hit(FightUnity unity){
        if(this.isAlive())
            unity.getDamage(15);
    }
    @Override
    public String toString(){
        return "Rider: lifePoints = " + this.lifePoints;
    }
}
class Platoon extends FightUnity{
    private FightUnity[] unities;
    public Platoon(FightUnity[] unities){
        this.unities = unities;
    }
    @Override
    public boolean isAlive(){
        for(FightUnity unity : unities){
            if(unity.isAlive()){
                return true;
            }
        }
        return false;
    }
    @Override
    public void getDamage(int damagePoints){
        for(FightUnity unity : unities){
            if(unity.isAlive()){
                unity.getDamage(damagePoints);
                break;
            }
        }
    }
    public void hit(FightUnity unity){
        for(FightUnity pUnity : unities){
            if(unity.isAlive() && pUnity.isAlive())
                pUnity.hit(unity);
        }
    }
    public String toString(){
        String result = "Platoon: ";
        for(FightUnity unity : unities){
            result += unity.toString();
        }
        return result;
    }
}
class Client{
    public static void main(String[] argv){
        Archer a1 = new Archer(100);
        Rider r1 = new Rider(200);
        System.out.println(a1.toString());
        System.out.println(r1.toString());
        a1.hit(r1);
        r1.hit(a1);
        System.out.println(a1.toString());
        System.out.println(r1.toString());
        Archer a11 = new Archer(100);
        Archer a12 = new Archer(100);
        Rider r11 = new Rider(200);
        Platoon p1 = new Platoon(new FightUnity[]{a11, a12, r11});
        System.out.println(p1.toString());
        Archer a21 = new Archer(100);
        Rider r21 = new Rider(200);
        Rider r22 = new Rider(200);
        Platoon p2 = new Platoon(new FightUnity[]{a21, r21, r22});
        p1.hit(p2);
        System.out.println(p2.toString());
    }
}