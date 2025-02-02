package io.fair_acc.dataset.event;

import io.fair_acc.dataset.AxisDescription;

/**
 * Event issued when only the name/unit changed
 * 
 * @see AxisDescription
 * 
 * @author rstein
 */
public class AxisNameChangeEvent extends AxisChangeEvent {
    private static final long serialVersionUID = -425352346909656104L;

    public AxisNameChangeEvent(EventSource evtSource) {
        super(evtSource);
    }

    public AxisNameChangeEvent(EventSource evtSource, int dimension) {
        super(evtSource, dimension);
    }

    public AxisNameChangeEvent(EventSource evtSource, String msg, int dimension) {
        super(evtSource, msg, dimension);
    }

    public AxisNameChangeEvent(EventSource evtSource, String msg, Object obj, int dimension) {
        super(evtSource, msg, obj, dimension);
    }
}
