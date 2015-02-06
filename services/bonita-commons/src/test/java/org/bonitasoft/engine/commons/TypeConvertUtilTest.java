package org.bonitasoft.engine.commons;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TypeConvertUtilTest {

    private TypeConverterUtil typeConverterUtil;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() {
        String[] datePatterns = new String[] { "yyyy-MM-dd HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd", "HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS" };
        typeConverterUtil = new TypeConverterUtil(datePatterns);
    }

    @Test
    public void should_convert_primitives() {

        assertThat((Long) typeConverterUtil.convertToType(Long.class, "15")).isEqualTo(15L);

        assertThat((Integer) typeConverterUtil.convertToType(Integer.class, "16")).isEqualTo(16);

        assertThat((Float) typeConverterUtil.convertToType(Float.class, "-17.596")).isEqualTo(-17.596F);

        final BigDecimal bigDecimal = new BigDecimal(12.3650000000000002131628207280300557613372802734375);
        assertThat((BigDecimal) typeConverterUtil.convertToType(BigDecimal.class, "12.3650000000000002131628207280300557613372802734375")).isEqualTo(bigDecimal);


        assertThat((Boolean) typeConverterUtil.convertToType(Boolean.class, "true")).isTrue();
        assertThat((Boolean) typeConverterUtil.convertToType(Boolean.class, "false")).isFalse();

        checkDateConvert(1422658800000L, "2015-01-31");
        checkDateConvert(1422742559000L, "2015-01-31 23:15:59");
        checkDateConvert(1422742559000L, "2015-01-31T23:15:59");
        checkDateConvert(1422742559001L, "2015-01-31T23:15:59.001");
        checkDateConvert(39600000L, "12:00:00");

    }

    @Test
    public void dateConvert_should_fail() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("unable to parse 'not a date' to type java.util.Date");

        typeConverterUtil.convertToType(Date.class, "not a date");
    }

    private void checkDateConvert(long dateLong, String dateToConvert) {
        final Date expectedDate = new Date(dateLong);
        final Date returnedDate = (Date) typeConverterUtil.convertToType(Date.class, dateToConvert);
        assertThat(returnedDate.getTime()).as("error with date:" + dateToConvert).isEqualTo(expectedDate.getTime());
    }



}
