package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a {@code Clock} to a {@link CesiumOutputStream}.  A {@code Clock} is initial settings for a simulated clock when a document is loaded.  The start and stop time are configured using the interval property.
 

 */
public class ClockCesiumWriter extends CesiumPropertyWriter<ClockCesiumWriter> {
    /**
    *  
    The name of the {@code currentTime} property.
    

    */
    public static final String CurrentTimePropertyName = "currentTime";
    /**
    *  
    The name of the {@code multiplier} property.
    

    */
    public static final String MultiplierPropertyName = "multiplier";
    /**
    *  
    The name of the {@code range} property.
    

    */
    public static final String RangePropertyName = "range";
    /**
    *  
    The name of the {@code step} property.
    

    */
    public static final String StepPropertyName = "step";

    /**
    *  
    Initializes a new instance.
    

    */
    public ClockCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected ClockCesiumWriter(ClockCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public ClockCesiumWriter clone() {
        return new ClockCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code currentTime}, which is the current time, specified in ISO8601 format.
    
    

    * @param value The time.
    */
    public final void writeCurrentTime(JulianDate value) {
        final String PropertyName = CurrentTimePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeDate(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code multiplier}, which is the multiplier.  When {@code step} is set to {@code TICK_DEPENDENT}, this is the number of seconds to advance each tick.  When {@code step} is set to {@code SYSTEM_CLOCK_DEPENDENT}, this is multiplied by the elapsed system time between ticks.  This value is ignored in {@code SYSTEM_CLOCK} mode.  The default value is 1.0.
    
    

    * @param value The value.
    */
    public final void writeMultiplier(double value) {
        final String PropertyName = MultiplierPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code range}, which is the behavior when the current time reaches its start or end times.  The default value is {@code LOOP_STOP}.
    
    

    * @param value The clock range.
    */
    public final void writeRange(ClockRange value) {
        final String PropertyName = RangePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.clockRangeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code step}, which is how the current time advances each tick.  The default value is {@code SYSTEM_CLOCK_MULTIPLIER}.
    
    

    * @param value The clock step.
    */
    public final void writeStep(ClockStep value) {
        final String PropertyName = StepPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.clockStepToString(value));
    }
}