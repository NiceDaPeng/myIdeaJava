package domain;

public class User {

    private Integer uid;
    private String uname;
    private String upassword;
    private String uemail;

    public User() {
    }

    public User(Integer uid, String uname, String upassword, String uemail) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.uemail = uemail;
    }

    public Integer getUid() {
        return this.uid;
    }

    public String getUname() {
        return this.uname;
    }

    public String getUpassword() {
        return this.upassword;
    }

    public String getUemail() {
        return this.uemail;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public void setUemail(String uemai) {
        this.uemail = uemail;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$uid = this.getUid();
        final Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) return false;
        final Object this$uname = this.getUname();
        final Object other$uname = other.getUname();
        if (this$uname == null ? other$uname != null : !this$uname.equals(other$uname)) return false;
        final Object this$upassword = this.getUpassword();
        final Object other$upassword = other.getUpassword();
        if (this$upassword == null ? other$upassword != null : !this$upassword.equals(other$upassword)) return false;
        final Object this$uemai = this.getUemail();
        final Object other$uemai = other.getUemail();
        if (this$uemai == null ? other$uemai != null : !this$uemai.equals(other$uemai)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $uid = this.getUid();
        result = result * PRIME + ($uid == null ? 43 : $uid.hashCode());
        final Object $uname = this.getUname();
        result = result * PRIME + ($uname == null ? 43 : $uname.hashCode());
        final Object $upassword = this.getUpassword();
        result = result * PRIME + ($upassword == null ? 43 : $upassword.hashCode());
        final Object $uemai = this.getUemail();
        result = result * PRIME + ($uemai == null ? 43 : $uemai.hashCode());
        return result;
    }

    public String toString() {
        return "User(uid=" + this.getUid() + ", uname=" + this.getUname() + ", upassword=" + this.getUpassword() + ", uemai=" + this.getUemail() + ")";
    }
}
