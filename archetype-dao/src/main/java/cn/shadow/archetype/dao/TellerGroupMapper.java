package cn.shadow.archetype.dao;

import cn.shadow.archetype.entity.TellerGroup;
import java.util.List;

public interface TellerGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teller_group
     *
     * @mbg.generated Thu Sep 19 21:48:05 CST 2019
     */
    int insert(TellerGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teller_group
     *
     * @mbg.generated Thu Sep 19 21:48:05 CST 2019
     */
    List<TellerGroup> selectAll();
}