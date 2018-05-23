public class Team {
private String name;
private boolean underdog;
public Team(String n) {
name = n;
underdog = false;
}
public Team(String n, boolean ud) {
name = n;
underdog = ud;
}
public String getName() {
return name;
}
public boolean isUnderdog() {
return underdog;
}
public String toString() {
return name;
}
}
