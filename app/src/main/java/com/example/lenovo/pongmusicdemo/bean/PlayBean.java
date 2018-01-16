package com.example.lenovo.pongmusicdemo.bean;

/**
 * Created by Menglucywhh on 2018/1/2.
 */

public class PlayBean {

    /**
     * error_code : 22000
     * bitrate : {"file_bitrate":64,"free":1,"file_link":"","file_extension":"mp3","original":0,"file_size":2679447,"file_duration":322,"show_link":"","song_file_id":42783748,"replay_gain":"0.000000"}
     * songinfo : {"res_reward_flag":"0","artist_id":"130","all_artist_id":"130","album_no":"1","pic_big":"http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_150","pic_small":"http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_90","relate_status":"1","resource_type":"0","copy_type":"0","lrclink":"http://qukufile2.qianqian.com/data2/lrc/238975978/238975978.lrc","pic_radio":"http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_300","toneid":"600902000004240302","all_rate":"64,128,192,256,320,flac","play_type":"","has_mv_mobile":1,"pic_premium":"http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_500","pic_huge":"","resource_type_ext":"0","bitrate_fee":"{\"0\":\"0|0\",\"1\":\"0|0\"}","publishtime":"1993-09-01","si_presale_flag":"0","del_status":"1","distribution":"1100000000,1100000000,1100000000,1100000000,1100000000,1100000000,1100000000,1100000000,1111111111,1100000000","file_duration":"326","si_proxycompany":"正东音乐娱乐咨询（北京）有限公司","info":"","has_filmtv":"0","biaoshi":"lossless","res_encryption_flag":"0","song_id":"877578","title":"海阔天空","ting_uid":"1100","author":"Beyond","album_id":"197864","album_title":"海阔天空","is_first_publish":0,"havehigh":2,"charge":0,"has_mv":1,"learn":1,"song_source":"web","piao_id":"0","korean_bb_song":"0","mv_provider":"1100000000","special_type":0,"collect_num":638,"share_num":165,"comment_num":147}
     */

    private int error_code;
    private BitrateBean bitrate;
    private SonginfoBean songinfo;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public BitrateBean getBitrate() {
        return bitrate;
    }

    public void setBitrate(BitrateBean bitrate) {
        this.bitrate = bitrate;
    }

    public SonginfoBean getSonginfo() {
        return songinfo;
    }

    public void setSonginfo(SonginfoBean songinfo) {
        this.songinfo = songinfo;
    }

    public static class BitrateBean {
        /**
         * file_bitrate : 64
         * free : 1
         * file_link :
         * file_extension : mp3
         * original : 0
         * file_size : 2679447
         * file_duration : 322
         * show_link :
         * song_file_id : 42783748
         * replay_gain : 0.000000
         */

        private int file_bitrate;
        private int free;
        private String file_link;
        private String file_extension;
        private int original;
        private int file_size;
        private int file_duration;
        private String show_link;
        private int song_file_id;
        private String replay_gain;

        public int getFile_bitrate() {
            return file_bitrate;
        }

        public void setFile_bitrate(int file_bitrate) {
            this.file_bitrate = file_bitrate;
        }

        public int getFree() {
            return free;
        }

        public void setFree(int free) {
            this.free = free;
        }

        public String getFile_link() {
            return file_link;
        }

        public void setFile_link(String file_link) {
            this.file_link = file_link;
        }

        public String getFile_extension() {
            return file_extension;
        }

        public void setFile_extension(String file_extension) {
            this.file_extension = file_extension;
        }

        public int getOriginal() {
            return original;
        }

        public void setOriginal(int original) {
            this.original = original;
        }

        public int getFile_size() {
            return file_size;
        }

        public void setFile_size(int file_size) {
            this.file_size = file_size;
        }

        public int getFile_duration() {
            return file_duration;
        }

        public void setFile_duration(int file_duration) {
            this.file_duration = file_duration;
        }

        public String getShow_link() {
            return show_link;
        }

        public void setShow_link(String show_link) {
            this.show_link = show_link;
        }

        public int getSong_file_id() {
            return song_file_id;
        }

        public void setSong_file_id(int song_file_id) {
            this.song_file_id = song_file_id;
        }

        public String getReplay_gain() {
            return replay_gain;
        }

        public void setReplay_gain(String replay_gain) {
            this.replay_gain = replay_gain;
        }
    }

    public static class SonginfoBean {
        /**
         * res_reward_flag : 0
         * artist_id : 130
         * all_artist_id : 130
         * album_no : 1
         * pic_big : http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_150
         * pic_small : http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_90
         * relate_status : 1
         * resource_type : 0
         * copy_type : 0
         * lrclink : http://qukufile2.qianqian.com/data2/lrc/238975978/238975978.lrc
         * pic_radio : http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_300
         * toneid : 600902000004240302
         * all_rate : 64,128,192,256,320,flac
         * play_type :
         * has_mv_mobile : 1
         * pic_premium : http://qukufile2.qianqian.com/data2/pic/88582702/88582702.jpg@s_0,w_500
         * pic_huge :
         * resource_type_ext : 0
         * bitrate_fee : {"0":"0|0","1":"0|0"}
         * publishtime : 1993-09-01
         * si_presale_flag : 0
         * del_status : 1
         * distribution : 1100000000,1100000000,1100000000,1100000000,1100000000,1100000000,1100000000,1100000000,1111111111,1100000000
         * file_duration : 326
         * si_proxycompany : 正东音乐娱乐咨询（北京）有限公司
         * info :
         * has_filmtv : 0
         * biaoshi : lossless
         * res_encryption_flag : 0
         * song_id : 877578
         * title : 海阔天空
         * ting_uid : 1100
         * author : Beyond
         * album_id : 197864
         * album_title : 海阔天空
         * is_first_publish : 0
         * havehigh : 2
         * charge : 0
         * has_mv : 1
         * learn : 1
         * song_source : web
         * piao_id : 0
         * korean_bb_song : 0
         * mv_provider : 1100000000
         * special_type : 0
         * collect_num : 638
         * share_num : 165
         * comment_num : 147
         */

        private String res_reward_flag;
        private String artist_id;
        private String all_artist_id;
        private String album_no;
        private String pic_big;
        private String pic_small;
        private String relate_status;
        private String resource_type;
        private String copy_type;
        private String lrclink;
        private String pic_radio;
        private String toneid;
        private String all_rate;
        private String play_type;
        private int has_mv_mobile;
        private String pic_premium;
        private String pic_huge;
        private String resource_type_ext;
        private String bitrate_fee;
        private String publishtime;
        private String si_presale_flag;
        private String del_status;
        private String distribution;
        private String file_duration;
        private String si_proxycompany;
        private String info;
        private String has_filmtv;
        private String biaoshi;
        private String res_encryption_flag;
        private String song_id;
        private String title;
        private String ting_uid;
        private String author;
        private String album_id;
        private String album_title;
        private int is_first_publish;
        private int havehigh;
        private int charge;
        private int has_mv;
        private int learn;
        private String song_source;
        private String piao_id;
        private String korean_bb_song;
        private String mv_provider;
        private int special_type;
        private int collect_num;
        private int share_num;
        private int comment_num;

        public String getRes_reward_flag() {
            return res_reward_flag;
        }

        public void setRes_reward_flag(String res_reward_flag) {
            this.res_reward_flag = res_reward_flag;
        }

        public String getArtist_id() {
            return artist_id;
        }

        public void setArtist_id(String artist_id) {
            this.artist_id = artist_id;
        }

        public String getAll_artist_id() {
            return all_artist_id;
        }

        public void setAll_artist_id(String all_artist_id) {
            this.all_artist_id = all_artist_id;
        }

        public String getAlbum_no() {
            return album_no;
        }

        public void setAlbum_no(String album_no) {
            this.album_no = album_no;
        }

        public String getPic_big() {
            return pic_big;
        }

        public void setPic_big(String pic_big) {
            this.pic_big = pic_big;
        }

        public String getPic_small() {
            return pic_small;
        }

        public void setPic_small(String pic_small) {
            this.pic_small = pic_small;
        }

        public String getRelate_status() {
            return relate_status;
        }

        public void setRelate_status(String relate_status) {
            this.relate_status = relate_status;
        }

        public String getResource_type() {
            return resource_type;
        }

        public void setResource_type(String resource_type) {
            this.resource_type = resource_type;
        }

        public String getCopy_type() {
            return copy_type;
        }

        public void setCopy_type(String copy_type) {
            this.copy_type = copy_type;
        }

        public String getLrclink() {
            return lrclink;
        }

        public void setLrclink(String lrclink) {
            this.lrclink = lrclink;
        }

        public String getPic_radio() {
            return pic_radio;
        }

        public void setPic_radio(String pic_radio) {
            this.pic_radio = pic_radio;
        }

        public String getToneid() {
            return toneid;
        }

        public void setToneid(String toneid) {
            this.toneid = toneid;
        }

        public String getAll_rate() {
            return all_rate;
        }

        public void setAll_rate(String all_rate) {
            this.all_rate = all_rate;
        }

        public String getPlay_type() {
            return play_type;
        }

        public void setPlay_type(String play_type) {
            this.play_type = play_type;
        }

        public int getHas_mv_mobile() {
            return has_mv_mobile;
        }

        public void setHas_mv_mobile(int has_mv_mobile) {
            this.has_mv_mobile = has_mv_mobile;
        }

        public String getPic_premium() {
            return pic_premium;
        }

        public void setPic_premium(String pic_premium) {
            this.pic_premium = pic_premium;
        }

        public String getPic_huge() {
            return pic_huge;
        }

        public void setPic_huge(String pic_huge) {
            this.pic_huge = pic_huge;
        }

        public String getResource_type_ext() {
            return resource_type_ext;
        }

        public void setResource_type_ext(String resource_type_ext) {
            this.resource_type_ext = resource_type_ext;
        }

        public String getBitrate_fee() {
            return bitrate_fee;
        }

        public void setBitrate_fee(String bitrate_fee) {
            this.bitrate_fee = bitrate_fee;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getSi_presale_flag() {
            return si_presale_flag;
        }

        public void setSi_presale_flag(String si_presale_flag) {
            this.si_presale_flag = si_presale_flag;
        }

        public String getDel_status() {
            return del_status;
        }

        public void setDel_status(String del_status) {
            this.del_status = del_status;
        }

        public String getDistribution() {
            return distribution;
        }

        public void setDistribution(String distribution) {
            this.distribution = distribution;
        }

        public String getFile_duration() {
            return file_duration;
        }

        public void setFile_duration(String file_duration) {
            this.file_duration = file_duration;
        }

        public String getSi_proxycompany() {
            return si_proxycompany;
        }

        public void setSi_proxycompany(String si_proxycompany) {
            this.si_proxycompany = si_proxycompany;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getHas_filmtv() {
            return has_filmtv;
        }

        public void setHas_filmtv(String has_filmtv) {
            this.has_filmtv = has_filmtv;
        }

        public String getBiaoshi() {
            return biaoshi;
        }

        public void setBiaoshi(String biaoshi) {
            this.biaoshi = biaoshi;
        }

        public String getRes_encryption_flag() {
            return res_encryption_flag;
        }

        public void setRes_encryption_flag(String res_encryption_flag) {
            this.res_encryption_flag = res_encryption_flag;
        }

        public String getSong_id() {
            return song_id;
        }

        public void setSong_id(String song_id) {
            this.song_id = song_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTing_uid() {
            return ting_uid;
        }

        public void setTing_uid(String ting_uid) {
            this.ting_uid = ting_uid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public String getAlbum_title() {
            return album_title;
        }

        public void setAlbum_title(String album_title) {
            this.album_title = album_title;
        }

        public int getIs_first_publish() {
            return is_first_publish;
        }

        public void setIs_first_publish(int is_first_publish) {
            this.is_first_publish = is_first_publish;
        }

        public int getHavehigh() {
            return havehigh;
        }

        public void setHavehigh(int havehigh) {
            this.havehigh = havehigh;
        }

        public int getCharge() {
            return charge;
        }

        public void setCharge(int charge) {
            this.charge = charge;
        }

        public int getHas_mv() {
            return has_mv;
        }

        public void setHas_mv(int has_mv) {
            this.has_mv = has_mv;
        }

        public int getLearn() {
            return learn;
        }

        public void setLearn(int learn) {
            this.learn = learn;
        }

        public String getSong_source() {
            return song_source;
        }

        public void setSong_source(String song_source) {
            this.song_source = song_source;
        }

        public String getPiao_id() {
            return piao_id;
        }

        public void setPiao_id(String piao_id) {
            this.piao_id = piao_id;
        }

        public String getKorean_bb_song() {
            return korean_bb_song;
        }

        public void setKorean_bb_song(String korean_bb_song) {
            this.korean_bb_song = korean_bb_song;
        }

        public String getMv_provider() {
            return mv_provider;
        }

        public void setMv_provider(String mv_provider) {
            this.mv_provider = mv_provider;
        }

        public int getSpecial_type() {
            return special_type;
        }

        public void setSpecial_type(int special_type) {
            this.special_type = special_type;
        }

        public int getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(int collect_num) {
            this.collect_num = collect_num;
        }

        public int getShare_num() {
            return share_num;
        }

        public void setShare_num(int share_num) {
            this.share_num = share_num;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }
    }
}
