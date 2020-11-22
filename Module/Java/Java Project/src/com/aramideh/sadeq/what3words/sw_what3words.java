package com.aramideh.sadeq.what3words;



import com.gesmallworld.magik.commons.interop.annotations.*;
import com.gesmallworld.magik.commons.runtime.objects.Symbol;
import com.gesmallworld.magik.interop.MagikInteropUtils;
import com.gesmallworld.magik.interop.MagikVectorUtils;
import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.request.BoundingBox;
import com.what3words.javawrapper.request.Coordinates;
import com.what3words.javawrapper.response.*;
import jdk.dynalink.beans.StaticClass;

import java.util.List;


/**
 * The type Sw what 3 words.
 */
@MagikExemplar(@Name(value = "what3words", pkg = "user"))
public class sw_what3words {

    private  static What3WordsV3 What3Words_API;
    private static String CLIP_TO_COUNTRY;
    private static String LANGUAGE;
    private static int MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS;
    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DEFAULT_ERROR_DATA_NAME="Error_Message";


    /**
     * Inner Class, defining Enumerated Conditions names, Please Check Conditions.magik in the related module folder
     */
    public static enum What3WordsMagikError {
        BAD_COORDINATES("w3w_BadCoordinates"),
        BAD_LANGUAGE("w3w_BadLanguage"),
        BAD_WORDS("w3w_BadWords"),
        NETWORK_ERROR("w3w_NetworkError"),
        INTERNAL_SERVER_ERROR("w3w_InternalServerError"),
        BAD_CLIP_TO_CIRCLE("w3w_BadClipToCircle"),
        BAD_CLIP_TO_BOUNDING_BOX("w3w_BadClipToBoundingBox"),
        BAD_CLIP_TO_COUNTRY("w3w_BadClipToCountry"),
        BAD_CLIP_TO_POLYGON("w3w_BadClipToCountry"),
        BAD_INPUT_WORDS_VALUE("Provided words is not a string"),
        BAD_INPUT_MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS("Input parameter NUmber of Results should be an Integer"),
        BAD_INPUT_STRING_VALUE("Input value is not a String"),
        BAD_INPUT_INTEGER_VALUE("Input value is not a Integer"),
        BAD_INPUT_ARRAY_VALUE("Input value is not a Array"),
        GENERIC_ERROR("w3w_GenericError");

        private final String message;

        What3WordsMagikError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }


    /**
     * Instantiates a new What3Words Magik Object
     */
    public sw_what3words() {
    }


    /**
     * Initialize open What3Words magik object.
     *
     * @return Magik what3words object
     */
    @ExemplarInstance
    public static Object initializeWhat3WordsMagik(){
        return new sw_what3words();
    }


    /**
     * New object.
     *
     * @param self     the self
     * @param api_key  the api key
     * @param language the language
     * @return the object
     */
    @MagikMethod("new()")
    public static Object _new(Object self , Object api_key ,@Optional Object language) {

        String mApiKey = null;
        try {
            mApiKey = MagikInteropUtils.fromMagikString( api_key);
        } catch (IllegalArgumentException e) {
            // not an string
            raiseMagikError(What3WordsMagikError.BAD_INPUT_STRING_VALUE.getMessage());
        }

            if ( language != null) {
                try {
                    LANGUAGE = MagikInteropUtils.fromMagikString( language );
                } catch (IllegalArgumentException e) {
                    // not an string
                    raiseMagikError(What3WordsMagikError.BAD_INPUT_STRING_VALUE.getMessage());
                }
            }else{
                LANGUAGE = DEFAULT_LANGUAGE;
            }

            //  Setting the number of auto suggestion results
         MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS = 5;

        What3Words_API = new What3WordsV3( mApiKey );
        return initializeWhat3WordsMagik();

    }


    /**
     * Gets clip to country.
     *
     * @return the clip to country
     */
    @MagikMethod("get_clip_to_country()")
    public final Object getClipToCountry() {
        if (CLIP_TO_COUNTRY != null){
            return MagikInteropUtils.toMagikString(CLIP_TO_COUNTRY);
        }
        return null;
    }

    /**
     * Sets clip to country.
     *
     * @param clipToCountry the clip to country
     */
    @MagikMethod("set_clip_to_country()")
    public final void setClipToCountry(Object clipToCountry) {
        try {
            CLIP_TO_COUNTRY = MagikInteropUtils.fromMagikString( clipToCountry );
        } catch (IllegalArgumentException e) {
            // not an string
            raiseMagikError(What3WordsMagikError.BAD_INPUT_STRING_VALUE.getMessage());
        }
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    @MagikMethod("get_language()")
    public final Object getLANGUAGE() {
        return MagikInteropUtils.toMagikString( LANGUAGE );
    }

    /**
     * Sets language.
     *
     */
    @MagikMethod("set_language()")
    public final void setLANGUAGE(Object language) {
        try {
            LANGUAGE = MagikInteropUtils.fromMagikString( language );
        } catch (IllegalArgumentException e) {
            // not an string
            raiseMagikError(What3WordsMagikError.BAD_INPUT_STRING_VALUE.getMessage());
        }
    }



    /**
     * Gets Maximum Number of Auto Suggestions Results
     *
     * @return the MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS value
     */
    @MagikMethod("get_maximum_number_of_auto_suggestions()")
    public final Object getMaximumNumberOfAutoSuggestionsResults() {
            // never null, because we initiated when the object created with the value of 5
            return MagikInteropUtils.toMagikInteger( MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS);
    }



    /**
     * Sets Maximum Number of Auto Suggestions Results
     *
     * @param
     */
    @MagikMethod("set_maximum_number_of_auto_suggestions()")
    public final void setMaximumNumberOfAutoSuggestionsResults(Object maximumNumberOfAutoSuggestionsResults) {
        try {
            MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS = MagikInteropUtils.fromMagikInteger( maximumNumberOfAutoSuggestionsResults );
        } catch (IllegalArgumentException e) {
            // not an string
            raiseMagikError(What3WordsMagikError.BAD_INPUT_MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS.getMessage());
        }

    }




    /**
     * Encode a coordinate to what3words.
     * This function converts coordinates (expressed as latitude and longitude) to a 3 word address.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return 3 words which defines the coordinate
     */
    @MagikMethod("encode()")
    public final Object encode(Object latitude, Object longitude ) {

            double mLatitude = MagikInteropUtils.fromMagikDouble(latitude);
            double mLongitude = MagikInteropUtils.fromMagikDouble(longitude);
            // Convert coordinates to a 3 word address
            ConvertTo3WA words = What3Words_API.convertTo3wa(new Coordinates(mLatitude, mLongitude))
                    .language( LANGUAGE )
                    .execute();

            if (words.isSuccessful()) {
                //System.out.println("Words: " + words);
                return MagikInteropUtils.toMagikString(words.getWords());

            } else {
                APIResponse.What3WordsError error = words.getError();
                if (error == APIResponse.What3WordsError.BAD_COORDINATES) {
                    //System.out.println("BadCoordinates: " + error.getMessage());
                    MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.BAD_COORDINATES.getMessage(),
                            Symbol.newSymbol("Latitude") , MagikInteropUtils.toMagikDouble(mLatitude) ,
                            Symbol.newSymbol("Longitude"), MagikInteropUtils.toMagikDouble(mLongitude ),
                            Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME),MagikInteropUtils.toMagikString(error.getMessage())
                            );
                } else if (error == APIResponse.What3WordsError.BAD_LANGUAGE) {
                    //System.out.println("BadLanguage: " + error.getMessage());
                    MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.BAD_LANGUAGE.getMessage() ,
                            Symbol.newSymbol("Language") , MagikInteropUtils.toMagikString(LANGUAGE ),
                            Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME) , MagikInteropUtils.toMagikString(error.getMessage()));
                }  else {
                  raiseMagikError(error);
                }
            }
        return null;
    }


    /**
     * Decode what3words to its respected coordinate.
     * This function converts a 3 word address to a position, expressed as coordinates of latitude and longitude.
     *
     * @param words the words
     * @return the multiple results => latitude,longitude
     */
    @MagikMethod("decode()")
    public final Object decode( Object words) {
        String WORDS = null;
        try {
                WORDS = MagikInteropUtils.fromMagikString(words);
        } catch (IllegalArgumentException e) {
            // not an string
        }
        // Convert a 3 word address to coordinates
        ConvertToCoordinates coordinates = What3Words_API.convertToCoordinates( WORDS)
                    .execute();

        if (coordinates.isSuccessful()) {
            return MagikInteropUtils.toMultipleResults(coordinates.getCoordinates().getLat(),coordinates.getCoordinates().getLng());
        } else {
            APIResponse.What3WordsError error = coordinates.getError();
            if (error == APIResponse.What3WordsError.BAD_WORDS) {
                //System.out.println("BadWords: " + error.getMessage());
                MagikInteropUtils.raiseMagikCondition( What3WordsMagikError.BAD_WORDS.getMessage() ,
                        Symbol.newSymbol("Words"),MagikInteropUtils.toMagikString(WORDS),
                        Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME),MagikInteropUtils.toMagikString(error.getMessage()) );
            } else {
                raiseMagikError(error);
            }
        }
        return null;
    }


    /**
     * Autosuggest for a words that user provided.
     * When presented with a 3 word address that may be incorrectly entered, AutoSuggest returns a list of potential correct 3 word addresses.
     * It needs the first two words plus at least the first character of the third word to produce suggestions.
     * This method provides corrections for mis-typed words (including plural vs singular), and words being in the wrong order.
     * <p>
     * Optionally, clipping can narrow down the possibilities, and limit results to:
     * <p>
     * One or more countries
     * A geographic area (a circle, box or polygon)
     * This dramatically improves results, so we recommend that you use clipping if possible.
     *
     * @param words    the words
     * @param nResults the n results
     * @return the suggestions for the words that user provided
     */
    @MagikMethod("get_suggestions()")
    public final Object autosuggest(Object words , @Optional Object nResults) {

        String Magik_3Words = null;
        try {
            Magik_3Words  = MagikInteropUtils.fromMagikString(words);
        } catch (IllegalArgumentException e) {
            // not an string
            raiseMagikError(What3WordsMagikError.BAD_INPUT_WORDS_VALUE.getMessage());
        }

        int Number_Of_Results = MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS;
        if ( nResults != null){
            try {
                Number_Of_Results = MagikInteropUtils.fromMagikInteger( nResults);
            } catch (IllegalArgumentException e) {
                // not an integer
                raiseMagikError( What3WordsMagikError.BAD_INPUT_MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS.getMessage());
            }
        }

        Autosuggest autosuggest;

        if (CLIP_TO_COUNTRY != null ) {
            autosuggest = What3Words_API.autosuggest( Magik_3Words )
                    .nResults(Number_Of_Results)
                    .clipToCountry( CLIP_TO_COUNTRY )
                    .execute();
        }else {
            autosuggest = What3Words_API.autosuggest(Magik_3Words )
                    .nResults(Number_Of_Results)
                    .execute();
        }


        APIResponse.What3WordsError error;
        if (autosuggest.isSuccessful()) {

            return AutoSuggestResult( autosuggest);

        } else {
            error = autosuggest.getError();
            raiseMagikError(error);
        }

        return null;
    }


    /**
     * Limit suggestion to bounding box.
     * <p>
     * When presented with a 3 word address that may be incorrectly entered, AutoSuggest returns a list of potential correct 3 word addresses.
     * It needs the first two words plus at least the first character of the third word to produce suggestions.
     * This method provides corrections for mis-typed words (including plural vs singular), and words being in the wrong order.
     * <p>
     * Optionally, clipping can narrow down the possibilities, and limit results to:
     * <p>
     * One or more countries
     * A geographic area (a circle, box or polygon)
     * This dramatically improves results, so we recommend that you use clipping if possible.
     *
     * @param words                                 the words
     * @param AutoSuggestBoundingBoxCoordinateArray the auto suggest bounding box coordinate array
     * @param nResults                              number of results
     * @return the object
     */
    @MagikMethod("limit_suggestions_to_boundingbox()")
    public final Object limit_autosuggest_to_boundingbox(Object words , Object AutoSuggestBoundingBoxCoordinateArray, @Optional Object nResults) {

        String Magik_3Words = null;
        try {
            Magik_3Words = MagikInteropUtils.fromMagikString(words);
        } catch (IllegalArgumentException e) {
            // not an string
            raiseMagikError(What3WordsMagikError.BAD_INPUT_STRING_VALUE.getMessage());
        }

        int Number_Of_Results = MAXIMUM_NUMBER_OF_AUTO_SUGGESTIONS_RESULTS;
        if (nResults != null) {
            try {
                Number_Of_Results = MagikInteropUtils.fromMagikInteger(nResults);
            } catch (IllegalArgumentException e) {
                // not an integer
                raiseMagikError(What3WordsMagikError.BAD_INPUT_INTEGER_VALUE.getMessage());
            }
        }

        /**
        BoundingBox boundingBox = null ;
        if (AutoSuggestBoundingBoxCoordinateArray != null) {
            try {
                double[] coords = MagikVectorUtils.getDoubleArray(AutoSuggestBoundingBoxCoordinateArray);
                double southLatitude = MagikInteropUtils.fromMagikDouble(coords[0]);
                double westLongitude = MagikInteropUtils.fromMagikDouble(coords[1]);
                double northLatitude = MagikInteropUtils.fromMagikDouble(coords[2]);
                double eastLongitude = MagikInteropUtils.fromMagikDouble(coords[3]);
                boundingBox = new BoundingBox(new Coordinates(southLatitude, westLongitude), new Coordinates(northLatitude, eastLongitude));
            } catch (IllegalArgumentException e) {
                // not an array
                raiseMagikError(What3WordsMagikError.BAD_INPUT_ARRAY_VALUE.getMessage());
            }
        }
         **/



        BoundingBox boundingBox = null ;
        if (AutoSuggestBoundingBoxCoordinateArray != null) {
            try {
                Object[] coords = MagikVectorUtils.getObjectArray(AutoSuggestBoundingBoxCoordinateArray);
                double southLatitude = MagikInteropUtils.fromMagikDouble(coords[0]);
                double westLongitude = MagikInteropUtils.fromMagikDouble(coords[1]);
                double northLatitude = MagikInteropUtils.fromMagikDouble(coords[2]);
                double eastLongitude = MagikInteropUtils.fromMagikDouble(coords[3]);
                boundingBox = new BoundingBox(new Coordinates(southLatitude, westLongitude), new Coordinates(northLatitude, eastLongitude));
            } catch (IllegalArgumentException e) {
                // not an array
                raiseMagikError(What3WordsMagikError.BAD_INPUT_ARRAY_VALUE.getMessage());
            }
        }


        Autosuggest autosuggest;

        if (CLIP_TO_COUNTRY != null ) {
            autosuggest = What3Words_API.autosuggest( Magik_3Words ).clipToBoundingBox(boundingBox)
                    .nResults(Number_Of_Results)
                    .clipToCountry( CLIP_TO_COUNTRY )
                    .execute();
        }else {
            autosuggest = What3Words_API.autosuggest(Magik_3Words).clipToBoundingBox(boundingBox)
                    .nResults(Number_Of_Results)
                    .execute();
        }


        APIResponse.What3WordsError error;
        if (autosuggest.isSuccessful()) {
                return AutoSuggestResult( autosuggest);
        } else {
                error = autosuggest.getError();
                  raiseMagikError(error);
        }

        return null;

    }


    /**
     * Method to get all the available languages in which what3words is available.
     * This function returns the currently supported languages. It will return the two letter code, and the name of the language only in English. ( Name in the native languge is also available but I didn't expose it)
     *
     * @return list of all available languages
     */
    @MagikMethod("available_languages()")
    public final Object AvailableLanguages() {

        AvailableLanguages languages = What3Words_API.availableLanguages().execute();
        if (languages.isSuccessful()) {
            //System.out.println("Languages: " + languages);
            List<Language> result = languages.getLanguages();

            StringBuilder stringBuilder = new StringBuilder();

            int i = 0;
            for ( Language lan: result) {
                //stringBuilder.append( lan.getCode()+','+lan.getName()+',' + lan.getNativeName() );
                stringBuilder.append( lan.getCode()+','+lan.getName() );
                stringBuilder.append(".");
            }
            //return  MagikVectorUtils.createMagikVector( magikResults ); // available in 5.2
            return MagikInteropUtils.toMagikString( stringBuilder.toString() );

        } else {
            APIResponse.What3WordsError error = languages.getError();
            raiseMagikError( error );
        }

        return null;
    }


    /**
     *  @return Auto Suggestion results to Magik Session
     */

    private Object AutoSuggestResult(Autosuggest autosuggest) {

        //System.out.println("Autosuggest: " + autosuggest);
        List<Suggestion> result = autosuggest .getSuggestions();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for ( Suggestion suggestion: result) {
            stringBuilder.append( suggestion.getCountry()+","+suggestion.getWords());
            stringBuilder.append("&");
        }
        String Result = "";
        if ( stringBuilder.length() > 0)
        {
            Result = stringBuilder.substring(0, stringBuilder.length()-1);
        }

        //return  MagikVectorUtils.createMagikVector( magikResults ); // available in 5.2
        return MagikInteropUtils.toMagikString( Result );
    }

//"GB,curve.shall.this.US,curve.shall.they.US,curve.shall.them."

    /**
     *  Raises a Condition in magik session
     *  @return
     */

    private void raiseMagikError(APIResponse.What3WordsError error) {

        if (error == APIResponse.What3WordsError.INTERNAL_SERVER_ERROR) {
            MagikInteropUtils.raiseMagikCondition( What3WordsMagikError.INTERNAL_SERVER_ERROR.getMessage() ,
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME) , MagikInteropUtils.toMagikString(error.getMessage() ));

        } else if (error == APIResponse.What3WordsError.NETWORK_ERROR) {
            MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.NETWORK_ERROR.getMessage(),
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME), MagikInteropUtils.toMagikString(error.getMessage() ));

        }else if (error == APIResponse.What3WordsError.BAD_CLIP_TO_CIRCLE) {
            MagikInteropUtils.raiseMagikCondition( What3WordsMagikError.BAD_CLIP_TO_CIRCLE.getMessage(),
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME),MagikInteropUtils.toMagikString( error.getMessage()));

        } else if (error == APIResponse.What3WordsError.BAD_CLIP_TO_BOUNDING_BOX) {
            MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.BAD_CLIP_TO_BOUNDING_BOX.getMessage(),
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME),MagikInteropUtils.toMagikString( error.getMessage()));

        } else if (error == APIResponse.What3WordsError.BAD_CLIP_TO_COUNTRY) {
            MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.BAD_CLIP_TO_COUNTRY.getMessage(),
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME),MagikInteropUtils.toMagikString( error.getMessage()));

        } else if (error == APIResponse.What3WordsError.BAD_CLIP_TO_POLYGON) {
            MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.BAD_CLIP_TO_POLYGON.getMessage(),
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME), MagikInteropUtils.toMagikString(error.getMessage()));
        }
        else{
            MagikInteropUtils.raiseMagikCondition(What3WordsMagikError.GENERIC_ERROR.getMessage(),
                    Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME), MagikInteropUtils.toMagikString(error.getMessage()));
            }
    }

    /**
     *  Raises a Condition in magik session
     *  @return
     */
    private static void raiseMagikError(String Error_Message) {
        MagikInteropUtils.raiseMagikCondition( What3WordsMagikError.GENERIC_ERROR.getMessage(),
                Symbol.newSymbol(DEFAULT_ERROR_DATA_NAME), MagikInteropUtils.toMagikString( Error_Message ));
    }

}
