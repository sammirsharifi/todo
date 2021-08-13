package domain;

import javax.persistence.*;

@Entity
@Table( name = Activity.TableName)
public class Activity {

   public static final String TableName="Activity_table";
   public static final String ActivityTypeName="Activity_type";
   public static final String CreateDate="CreateDate";
    public static final String UserId="UserId";
    public static final String ActivityName="ActivityName";

    @Id
    @GeneratedValue
    private Integer id;


    @Column(name = ActivityTypeName )
    private String activityType;

    @Column(name = CreateDate )
    private String createDate;



    @Column(name = UserId)
    private Integer user;

    @Column(name = ActivityName )
    private String activityName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int compareToById(Activity o) {
        if (o.getId()== null || id == null) {
            return 0;
        }
        return id.compareTo(o.getId());
    }

    public int compareToByType(Activity o) {
        if (o.getActivityType()== null || activityType == null) {
            return 0;
        }
        return activityType.compareTo(o.getActivityType());
    }
    public int compareToByName(Activity o) {
        if (o.getActivityName()== null || activityName == null) {
            return 0;
        }
        return activityName.compareTo(o.getActivityName());
    }


    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityType='" + activityType + '\'' +
                ", createDate='" + createDate + '\'' +
                ", activityName='" + activityName + '\'' +
                '}';
    }
}

