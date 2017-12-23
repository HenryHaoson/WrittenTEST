package com.henryhaoson.expendview.entity.resEntity;

import java.util.List;

/**
 * Author : zhuhao
 * Date : 23/12/2017
 *
 * @Last Modified Time :23/12/2017
 * Description :
 */

public class WordExplainEntity {


    /**
     * msg : SUCCESS
     * status_code : 0
     * data : {"pronunciations":{"uk":"'riːəli","us":"'riːəli"},"en_definitions":{"adv":["in accordance with truth or fact or reality","in actual fact","in fact (used as intensifiers or sentence modifiers)"]},"audio_addresses":{"uk":["https://media-audio1.baydn.com/uk%2Fr%2Fre%2Freally_v4.mp3","http://media-audio1.qiniu.baydn.com/uk/r/re/really_v4.mp3"],"us":["https://media-audio1.baydn.com/us%2Fr%2Fre%2Freally_v4.mp3","http://media-audio1.qiniu.baydn.com/us/r/re/really_v4.mp3"]},"uk_audio":"http://media.shanbay.com/audio/uk/really.mp3","conent_id":4987,"audio_name":"really_v4","cn_definition":{"pos":"","defn":"adv. 真正地,实在，事实上"},"num_sense":1,"content_id":4987,"content_type":"vocabulary","sense_id":0,"id":4987,"definition":" adv. 真正地,实在，事实上","has_collins_defn":true,"has_oxford_defn":true,"url":"https://www.shanbay.com/bdc/mobile/preview/word?word=really","has_audio":true,"en_definition":{"pos":"adv","defn":"in accordance with truth or fact or reality; in actual fact; in fact (used as intensifiers or sentence modifiers)"},"object_id":4987,"content":"really","pron":"'riːəli","pronunciation":"'riːəli","id_str":"btiyhg","audio":"http://media.shanbay.com/audio/us/really.mp3","us_audio":"http://media.shanbay.com/audio/us/really.mp3"}
     */

    private String msg;
    private int status_code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pronunciations : {"uk":"'riːəli","us":"'riːəli"}
         * en_definitions : {"adv":["in accordance with truth or fact or reality","in actual fact","in fact (used as intensifiers or sentence modifiers)"]}
         * audio_addresses : {"uk":["https://media-audio1.baydn.com/uk%2Fr%2Fre%2Freally_v4.mp3","http://media-audio1.qiniu.baydn.com/uk/r/re/really_v4.mp3"],"us":["https://media-audio1.baydn.com/us%2Fr%2Fre%2Freally_v4.mp3","http://media-audio1.qiniu.baydn.com/us/r/re/really_v4.mp3"]}
         * uk_audio : http://media.shanbay.com/audio/uk/really.mp3
         * conent_id : 4987
         * audio_name : really_v4
         * cn_definition : {"pos":"","defn":"adv. 真正地,实在，事实上"}
         * num_sense : 1
         * content_id : 4987
         * content_type : vocabulary
         * sense_id : 0
         * id : 4987
         * definition :  adv. 真正地,实在，事实上
         * has_collins_defn : true
         * has_oxford_defn : true
         * url : https://www.shanbay.com/bdc/mobile/preview/word?word=really
         * has_audio : true
         * en_definition : {"pos":"adv","defn":"in accordance with truth or fact or reality; in actual fact; in fact (used as intensifiers or sentence modifiers)"}
         * object_id : 4987
         * content : really
         * pron : 'riːəli
         * pronunciation : 'riːəli
         * id_str : btiyhg
         * audio : http://media.shanbay.com/audio/us/really.mp3
         * us_audio : http://media.shanbay.com/audio/us/really.mp3
         */

        private PronunciationsBean pronunciations;
        private EnDefinitionsBean en_definitions;
        private AudioAddressesBean audio_addresses;
        private String uk_audio;
        private int conent_id;
        private String audio_name;
        private CnDefinitionBean cn_definition;
        private int num_sense;
        private int content_id;
        private String content_type;
        private int sense_id;
        private int id;
        private String definition;
        private boolean has_collins_defn;
        private boolean has_oxford_defn;
        private String url;
        private boolean has_audio;
        private EnDefinitionBean en_definition;
        private int object_id;
        private String content;
        private String pron;
        private String pronunciation;
        private String id_str;
        private String audio;
        private String us_audio;

        public PronunciationsBean getPronunciations() {
            return pronunciations;
        }

        public void setPronunciations(PronunciationsBean pronunciations) {
            this.pronunciations = pronunciations;
        }

        public EnDefinitionsBean getEn_definitions() {
            return en_definitions;
        }

        public void setEn_definitions(EnDefinitionsBean en_definitions) {
            this.en_definitions = en_definitions;
        }

        public AudioAddressesBean getAudio_addresses() {
            return audio_addresses;
        }

        public void setAudio_addresses(AudioAddressesBean audio_addresses) {
            this.audio_addresses = audio_addresses;
        }

        public String getUk_audio() {
            return uk_audio;
        }

        public void setUk_audio(String uk_audio) {
            this.uk_audio = uk_audio;
        }

        public int getConent_id() {
            return conent_id;
        }

        public void setConent_id(int conent_id) {
            this.conent_id = conent_id;
        }

        public String getAudio_name() {
            return audio_name;
        }

        public void setAudio_name(String audio_name) {
            this.audio_name = audio_name;
        }

        public CnDefinitionBean getCn_definition() {
            return cn_definition;
        }

        public void setCn_definition(CnDefinitionBean cn_definition) {
            this.cn_definition = cn_definition;
        }

        public int getNum_sense() {
            return num_sense;
        }

        public void setNum_sense(int num_sense) {
            this.num_sense = num_sense;
        }

        public int getContent_id() {
            return content_id;
        }

        public void setContent_id(int content_id) {
            this.content_id = content_id;
        }

        public String getContent_type() {
            return content_type;
        }

        public void setContent_type(String content_type) {
            this.content_type = content_type;
        }

        public int getSense_id() {
            return sense_id;
        }

        public void setSense_id(int sense_id) {
            this.sense_id = sense_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDefinition() {
            return definition;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public boolean isHas_collins_defn() {
            return has_collins_defn;
        }

        public void setHas_collins_defn(boolean has_collins_defn) {
            this.has_collins_defn = has_collins_defn;
        }

        public boolean isHas_oxford_defn() {
            return has_oxford_defn;
        }

        public void setHas_oxford_defn(boolean has_oxford_defn) {
            this.has_oxford_defn = has_oxford_defn;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isHas_audio() {
            return has_audio;
        }

        public void setHas_audio(boolean has_audio) {
            this.has_audio = has_audio;
        }

        public EnDefinitionBean getEn_definition() {
            return en_definition;
        }

        public void setEn_definition(EnDefinitionBean en_definition) {
            this.en_definition = en_definition;
        }

        public int getObject_id() {
            return object_id;
        }

        public void setObject_id(int object_id) {
            this.object_id = object_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPron() {
            return pron;
        }

        public void setPron(String pron) {
            this.pron = pron;
        }

        public String getPronunciation() {
            return pronunciation;
        }

        public void setPronunciation(String pronunciation) {
            this.pronunciation = pronunciation;
        }

        public String getId_str() {
            return id_str;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getUs_audio() {
            return us_audio;
        }

        public void setUs_audio(String us_audio) {
            this.us_audio = us_audio;
        }

        public static class PronunciationsBean {
            /**
             * uk : 'riːəli
             * us : 'riːəli
             */

            private String uk;
            private String us;

            public String getUk() {
                return uk;
            }

            public void setUk(String uk) {
                this.uk = uk;
            }

            public String getUs() {
                return us;
            }

            public void setUs(String us) {
                this.us = us;
            }
        }

        public static class EnDefinitionsBean {
            private List<String> adv;

            public List<String> getAdv() {
                return adv;
            }

            public void setAdv(List<String> adv) {
                this.adv = adv;
            }
        }

        public static class AudioAddressesBean {
            private List<String> uk;
            private List<String> us;

            public List<String> getUk() {
                return uk;
            }

            public void setUk(List<String> uk) {
                this.uk = uk;
            }

            public List<String> getUs() {
                return us;
            }

            public void setUs(List<String> us) {
                this.us = us;
            }
        }

        public static class CnDefinitionBean {
            /**
             * pos :
             * defn : adv. 真正地,实在，事实上
             */

            private String pos;
            private String defn;

            public String getPos() {
                return pos;
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public String getDefn() {
                return defn;
            }

            public void setDefn(String defn) {
                this.defn = defn;
            }
        }

        public static class EnDefinitionBean {
            /**
             * pos : adv
             * defn : in accordance with truth or fact or reality; in actual fact; in fact (used as intensifiers or sentence modifiers)
             */

            private String pos;
            private String defn;

            public String getPos() {
                return pos;
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public String getDefn() {
                return defn;
            }

            public void setDefn(String defn) {
                this.defn = defn;
            }
        }
    }
}
