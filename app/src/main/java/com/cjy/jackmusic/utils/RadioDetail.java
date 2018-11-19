package com.cjy.jackmusic.utils;

import java.util.List;

public class RadioDetail {


    /**
     * code : 200
     * message : 成功!
     * result : {"channel":"漫步春天","count":null,"ch_name":"public_tuijian_spring","artistid":null,"avatar":null,"songlist":[{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/12D27ABDE0E75BD0C32D86AAF2C8188F/252191207/252191207.jpg@s_0,w_90","all_artist_id":"931","resource_type":"0","havehigh":2,"title":"一整片天空","songid":"1249078","artist_id":"931","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"陈绮贞","thumb":"http://qukufile2.qianqian.com/data2/pic/9f63c6b3c2795395d422f9818d83287d/68624/68624.jpg@s_1,w_90,h_90","all_artist_id":"429","resource_type":"0","havehigh":2,"title":"让我想一想","songid":"283493","artist_id":"429","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"苏慧伦","thumb":"http://qukufile2.qianqian.com/data2/pic/70883433240509d03e93342800d86b5d/166527/166527.jpg@s_1,w_90,h_90","all_artist_id":"322","resource_type":"0","havehigh":2,"title":"Lemon Tree","songid":"1631731","artist_id":"322","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"许绍洋","thumb":"http://qukufile2.qianqian.com/data2/pic/a04eccb139402920c53fca6e8b1614fe/108466/108466.jpg@s_1,w_90,h_90","all_artist_id":"333","resource_type":"0","havehigh":2,"title":"花香","songid":"1123781","artist_id":"333","flow":0},{"all_rate":"32,64,128,256,320,flac","charge":0,"method":0,"artist":"郁可唯","thumb":"http://qukufile2.qianqian.com/data2/pic/4da2d193769c88f39c95b88b474fd1a8/578956117/578956117.jpg@s_1,w_90,h_90","all_artist_id":"1656","resource_type":"0","havehigh":2,"title":"暖心","songid":"537345","artist_id":"1656","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"羽泉","thumb":"http://qukufile2.qianqian.com/data2/pic/88555531/88555531.jpg@s_0,w_90","all_artist_id":"786","resource_type":"0","havehigh":2,"title":"彩虹","songid":"976984","artist_id":"786","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"李心洁","thumb":"http://qukufile2.qianqian.com/data2/pic/42815702e978e2edc30ec9dd946a8319/62482/62482.jpg@s_1,w_90,h_90","all_artist_id":"210","resource_type":"0","havehigh":2,"title":"Happy Tune","songid":"238861","artist_id":"210","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"陈绮贞","thumb":"http://qukufile2.qianqian.com/data2/pic/829663acc8201cb05dbe484a6d6c672f/186087/186087.jpg@s_1,w_90,h_90","all_artist_id":"429","resource_type":"0","havehigh":2,"title":"下午三点","songid":"621079","artist_id":"429","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/12D27ABDE0E75BD0C32D86AAF2C8188F/252191207/252191207.jpg@s_0,w_90","all_artist_id":"931","resource_type":"0","havehigh":2,"title":"花的话","songid":"218267","artist_id":"931","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"曹格","thumb":"http://qukufile2.qianqian.com/data2/pic/4354abbe4e167688703e2da1ae5c4a2d/145111/145111.jpg@s_1,w_90,h_90","all_artist_id":"488","resource_type":"0","havehigh":2,"title":"吹吹风","songid":"450485","artist_id":"488","flow":0},{"all_rate":"","charge":0,"method":0,"artist":null,"thumb":"","all_artist_id":null,"resource_type":null,"havehigh":0,"title":null,"songid":null,"artist_id":null,"flow":0}],"channelid":null}
     */

    private int code;
    private String message;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * channel : 漫步春天
         * count : null
         * ch_name : public_tuijian_spring
         * artistid : null
         * avatar : null
         * songlist : [{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/12D27ABDE0E75BD0C32D86AAF2C8188F/252191207/252191207.jpg@s_0,w_90","all_artist_id":"931","resource_type":"0","havehigh":2,"title":"一整片天空","songid":"1249078","artist_id":"931","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"陈绮贞","thumb":"http://qukufile2.qianqian.com/data2/pic/9f63c6b3c2795395d422f9818d83287d/68624/68624.jpg@s_1,w_90,h_90","all_artist_id":"429","resource_type":"0","havehigh":2,"title":"让我想一想","songid":"283493","artist_id":"429","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"苏慧伦","thumb":"http://qukufile2.qianqian.com/data2/pic/70883433240509d03e93342800d86b5d/166527/166527.jpg@s_1,w_90,h_90","all_artist_id":"322","resource_type":"0","havehigh":2,"title":"Lemon Tree","songid":"1631731","artist_id":"322","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"许绍洋","thumb":"http://qukufile2.qianqian.com/data2/pic/a04eccb139402920c53fca6e8b1614fe/108466/108466.jpg@s_1,w_90,h_90","all_artist_id":"333","resource_type":"0","havehigh":2,"title":"花香","songid":"1123781","artist_id":"333","flow":0},{"all_rate":"32,64,128,256,320,flac","charge":0,"method":0,"artist":"郁可唯","thumb":"http://qukufile2.qianqian.com/data2/pic/4da2d193769c88f39c95b88b474fd1a8/578956117/578956117.jpg@s_1,w_90,h_90","all_artist_id":"1656","resource_type":"0","havehigh":2,"title":"暖心","songid":"537345","artist_id":"1656","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"羽泉","thumb":"http://qukufile2.qianqian.com/data2/pic/88555531/88555531.jpg@s_0,w_90","all_artist_id":"786","resource_type":"0","havehigh":2,"title":"彩虹","songid":"976984","artist_id":"786","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"李心洁","thumb":"http://qukufile2.qianqian.com/data2/pic/42815702e978e2edc30ec9dd946a8319/62482/62482.jpg@s_1,w_90,h_90","all_artist_id":"210","resource_type":"0","havehigh":2,"title":"Happy Tune","songid":"238861","artist_id":"210","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"陈绮贞","thumb":"http://qukufile2.qianqian.com/data2/pic/829663acc8201cb05dbe484a6d6c672f/186087/186087.jpg@s_1,w_90,h_90","all_artist_id":"429","resource_type":"0","havehigh":2,"title":"下午三点","songid":"621079","artist_id":"429","flow":0},{"all_rate":"96,128,224,320,flac","charge":0,"method":0,"artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/12D27ABDE0E75BD0C32D86AAF2C8188F/252191207/252191207.jpg@s_0,w_90","all_artist_id":"931","resource_type":"0","havehigh":2,"title":"花的话","songid":"218267","artist_id":"931","flow":0},{"all_rate":"64,96,128,224,320,flac","charge":0,"method":0,"artist":"曹格","thumb":"http://qukufile2.qianqian.com/data2/pic/4354abbe4e167688703e2da1ae5c4a2d/145111/145111.jpg@s_1,w_90,h_90","all_artist_id":"488","resource_type":"0","havehigh":2,"title":"吹吹风","songid":"450485","artist_id":"488","flow":0},{"all_rate":"","charge":0,"method":0,"artist":null,"thumb":"","all_artist_id":null,"resource_type":null,"havehigh":0,"title":null,"songid":null,"artist_id":null,"flow":0}]
         * channelid : null
         */

        private String channel;
        private Object count;
        private String ch_name;
        private Object artistid;
        private Object avatar;
        private Object channelid;
        private List<SonglistBean> songlist;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public Object getCount() {
            return count;
        }

        public void setCount(Object count) {
            this.count = count;
        }

        public String getCh_name() {
            return ch_name;
        }

        public void setCh_name(String ch_name) {
            this.ch_name = ch_name;
        }

        public Object getArtistid() {
            return artistid;
        }

        public void setArtistid(Object artistid) {
            this.artistid = artistid;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public Object getChannelid() {
            return channelid;
        }

        public void setChannelid(Object channelid) {
            this.channelid = channelid;
        }

        public List<SonglistBean> getSonglist() {
            return songlist;
        }

        public void setSonglist(List<SonglistBean> songlist) {
            this.songlist = songlist;
        }

        public static class SonglistBean {
            /**
             * all_rate : 96,128,224,320,flac
             * charge : 0
             * method : 0
             * artist : 易桀齐
             * thumb : http://qukufile2.qianqian.com/data2/music/12D27ABDE0E75BD0C32D86AAF2C8188F/252191207/252191207.jpg@s_0,w_90
             * all_artist_id : 931
             * resource_type : 0
             * havehigh : 2
             * title : 一整片天空
             * songid : 1249078
             * artist_id : 931
             * flow : 0
             */

            private String all_rate;
            private int charge;
            private int method;
            private String artist;
            private String thumb;
            private String all_artist_id;
            private String resource_type;
            private int havehigh;
            private String title;
            private String songid;
            private String artist_id;
            private int flow;

            public String getAll_rate() {
                return all_rate;
            }

            public void setAll_rate(String all_rate) {
                this.all_rate = all_rate;
            }

            public int getCharge() {
                return charge;
            }

            public void setCharge(int charge) {
                this.charge = charge;
            }

            public int getMethod() {
                return method;
            }

            public void setMethod(int method) {
                this.method = method;
            }

            public String getArtist() {
                return artist;
            }

            public void setArtist(String artist) {
                this.artist = artist;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getAll_artist_id() {
                return all_artist_id;
            }

            public void setAll_artist_id(String all_artist_id) {
                this.all_artist_id = all_artist_id;
            }

            public String getResource_type() {
                return resource_type;
            }

            public void setResource_type(String resource_type) {
                this.resource_type = resource_type;
            }

            public int getHavehigh() {
                return havehigh;
            }

            public void setHavehigh(int havehigh) {
                this.havehigh = havehigh;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSongid() {
                return songid;
            }

            public void setSongid(String songid) {
                this.songid = songid;
            }

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }

            public int getFlow() {
                return flow;
            }

            public void setFlow(int flow) {
                this.flow = flow;
            }
        }
    }
}