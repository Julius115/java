package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Supporter;
import org.mybatis.cdi.Mapper;

@Mapper
public interface SupporterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUPPORTER
     *
     * @mbg.generated Tue Apr 17 21:44:50 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUPPORTER
     *
     * @mbg.generated Tue Apr 17 21:44:50 EEST 2018
     */
    int insert(Supporter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUPPORTER
     *
     * @mbg.generated Tue Apr 17 21:44:50 EEST 2018
     */
    Supporter selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUPPORTER
     *
     * @mbg.generated Tue Apr 17 21:44:50 EEST 2018
     */
    List<Supporter> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SUPPORTER
     *
     * @mbg.generated Tue Apr 17 21:44:50 EEST 2018
     */
    int updateByPrimaryKey(Supporter record);
}