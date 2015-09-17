package com.hczhang.hummingbird.event;

import java.io.Serializable;
import java.util.Map;

/**
 * Event Class. A event should be serializable. Serializable module will be used to help framework to do this.
 * A Event class should have following properties:
 * <p>
 * 1. ID, every event has a unique ID. <br>
 * 2. Command ID, generated by command object. we could think this is transaction ID. <br>
 * 3. Aggregate ID, which identify which object will be applied with this event. <br>
 * 4. Timestamp, when the event was been created. <br>
 *
 * MetaData is optional property for event. We could load with some extra data, e.g. audit information etc.
 *
 * Created by steven on 3/21/14.
 * @param <ID>   the type parameter
 */
public interface Event<ID> extends Serializable {

    /**
     * Get event id.
     * @return event id.
     */
    String getID();

    /**
     * Get aggregate id.
     * @return aggregate id
     */
    ID getAggregateID();

    /**
     * Get version of model.
     * When the current event is applied, the model will be this {@code version}
     * @return version version
     */
    long getVersion();

    /**
     * Get command id or transaction id.
     * @return command id.
     */
    String getCommandID();

    /**
     * Get event created timestamp.
     * @return created timestamp.
     */
    long getTimestamp();

    /**
     * Set version of Aggregate after this event is applied.
     * @param version the version
     */
    void setVersion(long version);

    /**
     * Append meta data.
     * @param metaData will be appended data.
     * @return A merged event.
     */
    Event withMetaData(Map<String, String> metaData);

    /**
     * Append a single meta data.
     * @param key name of value
     * @param value a value of meta data
     * @return A merged event.
     */
    Event withMetaData(String key, String value);

    /**
     * Get meta data, which is extra data for event.
     * @return meta data.
     */
    Map<String, String> getMetaData();

    /**
     * Get a single value of specific key.
     * @param key a key of value
     * @return meta data
     */
    String getMetaData(String key);
}
