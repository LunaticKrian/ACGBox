package wiki.acgcsbox.model.po;

import lombok.Data;
import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author : XiaoBai
 * @apiNote
 * @date : 2023/4/4 20:50
 */
@Data
public class BasePo  implements Serializable {
    /**
     * 主键ID
     */
    @Column(name = "id")
    private String id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 创建人ID
     */
    @Column(name = "create_user")
    private Integer createUser;

    /**
     * 修改人ID
     */
    @Column(name = "update_user")
    private Integer updateUser;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;
}
