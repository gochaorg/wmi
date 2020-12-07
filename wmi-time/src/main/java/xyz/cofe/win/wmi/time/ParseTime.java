package xyz.cofe.win.wmi.time;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTime {
    protected static class Format {
        public final Pattern pattern;
        public final BiFunction<String, Matcher, OffsetDateTime> parse;
        public Format(Pattern pattern, BiFunction<String, Matcher, OffsetDateTime> parse){
            this.pattern = pattern;
            this.parse = parse;
        }
    }

    protected static final DateTimeFormatter dtFmt1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSSSSS");
    protected static final Pattern ptrn1 = Pattern.compile("(?<dt>\\d{14}\\.\\d{6})(?<minOff>[+\\-]\\d+)");
    protected static final Format fmt1 = new Format(ptrn1,(line,m)->{
        String minOffStr = m.group("minOff");
        int minOff = Integer.parseInt(minOffStr);

        LocalDateTime lDt = LocalDateTime.parse(m.group("dt"),dtFmt1);
        return lDt.atOffset(ZoneOffset.ofTotalSeconds(minOff*60));
    });
    protected static final Format[] formats = new Format[]{
        fmt1
    };

    public static Optional<OffsetDateTime> parse(String datetimeString){
        if( datetimeString==null )throw new IllegalArgumentException("datetimeString==null");
        for( Format f:formats ){
            Matcher m = f.pattern.matcher(datetimeString);
            if( m.matches() ){
                OffsetDateTime oDt = f.parse.apply(datetimeString,m);
                return Optional.of(oDt);
            }
        }
        return Optional.empty();
    }
}
