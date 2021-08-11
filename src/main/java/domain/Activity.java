package domain;

import javax.persistence.*;

@Entity
@Table( name = Activity.TableName)
public class Activity {

   public static final String TableName="Activity_table";
   public static final String ActivityTypeName="Activity_type";
   public static final String CreateDate="CreateDate";
    public static final String UserId="UserId";
    @Id
    @GeneratedValue
    private Integer id;


    @Column(name = ActivityTypeName )
    private String activityType;

    @Column(name = CreateDate )
    private String createDate;



    @Column(name = UserId)
    private Integer user;

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



    }

    enum  ActivityEnum
    {
        Open, InProgress, Completed
    }