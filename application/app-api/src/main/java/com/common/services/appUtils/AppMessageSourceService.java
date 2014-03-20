package com.common.services.appUtils;


public interface AppMessageSourceService {
    /**
     * Try to resolve the message.
     * @param code - the code to lookup up, such as 'calculator.noRateSet'
     * @return String
     */
    String getMessage(String code);

    /**
     * Try to resolve the message.
     * @param code - the code to lookup up, such as 'calculator.noRateSet'
     * @param args - array of arguments that will be filled in for params within the message
     *                (params look like "{0}", "{1,date}", "{2,time}" within a message), or null if none.
     * @return String
     */
    String getMessage(String code, Object[] args);

    /**
     * Try to resolve the message.
     * Return default message if no message was found.
     * @param code - the code to lookup up, such as 'calculator.noRateSet'
     * @param args - array of arguments that will be filled in for params within the message
     *                (params look like "{0}", "{1,date}", "{2,time}" within a message), or null if none.
     * @param defaultMessage - string to return if the lookup fails
     * @return String
     */
    String getMessage(String code, Object[] args, String defaultMessage);

    /**
     * Gets Yes/No message for boolean value.
     * @param val - boolean value
     * @return String representation of boolean value
     */
    public String getMessage(boolean val);
}
