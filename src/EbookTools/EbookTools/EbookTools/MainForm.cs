using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using HtmlAgilityPack;

namespace EbookTools
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private string mainUrl;
        private string filterWord;
        private string urlHeader;

        private void btnStart_Click(object sender, EventArgs e)
        {
            //TODO:开始抓取网页内容
            lbProgress.Items.Clear();

            mainUrl = txtUrl.Text.Trim();
            filterWord = txtKeyword.Text.Trim();

            string[] temp = mainUrl.Split('/');
            urlHeader = temp[0] + "//" + temp[2] + "/";

            List<string> lsUrl = GetLinks(mainUrl, filterWord);
            AddUrlHeader(lsUrl, urlHeader);

            foreach (string t in lsUrl)
            {
                AddLog(t);
            }
        }

        private void AddLog(string msg)
        {
            lbProgress.Items.Add(msg);
        }

        /// <summary>
        /// 获取特定Url上符合“keyWord”的所有url
        /// </summary>
        /// <param name="uri"></param>
        /// <param name="key"></param>
        /// <returns></returns>
        public List<string> GetLinks(string uri, string key)
        {
            List<string> lsHref = new List<string>();

            HtmlWeb web = new HtmlWeb();
            HtmlAgilityPack.HtmlDocument document = web.Load(uri);
            StringBuilder anyString = new StringBuilder(1024);
            //获取指定url包含的所有href元素内容，即超链接.
            HtmlNodeCollection nodes = document.DocumentNode.SelectNodes("//a[@href]");

            if (nodes != null)
            {
                string result = string.Empty;
                foreach (HtmlNode link in nodes)
                {
                    //anyString.AppendLine(link.InnerText.Trim());
                    //anyString.AppendLine(link.GetAttributeValue("href", "Not Found"));

                    //lsHref.Add(link.InnerText.Trim());
                    //lsHref.Add(link.GetAttributeValue("href", "Not Found"));

                    result = link.GetAttributeValue("href", "Not Found"); //获取href标签元素内容

                    if (!string.IsNullOrEmpty(key))
                    {
                        if (result.Contains(key) && (result.EndsWith(".html") || result.EndsWith(".htm")))
                        {
                            lsHref.Add(result);
                        }
                    }
                    else
                    {
                        lsHref.Add(result);
                    }
                }
            }
            return lsHref;
        }

        /// <summary>
        /// 相对链接路径修改为绝对路径, 如 /min/123.html 修改为 www.123.com.cn/min/123.html
        /// </summary>
        /// <param name="lsUrls"></param>
        /// <param name="header"></param>
        private void AddUrlHeader(List<string> lsUrls, string header)
        {
            string tmp = string.Empty;
            for (int i = 0; i < lsUrls.Count; i++)
            {
                tmp = lsUrls[i];
                if (!tmp.StartsWith("http://", StringComparison.CurrentCultureIgnoreCase) || !tmp.StartsWith("www.", StringComparison.CurrentCultureIgnoreCase))
                {
                    if (tmp.StartsWith("/"))
                    {
                        tmp = tmp.Remove(0, 1); // /min/123.html  ---去除开始的字符"/"
                    }
                    lsUrls[i] = header + tmp;
                }
            }
        }

        private void btnClearKeyword_Click(object sender, EventArgs e)
        {
            txtKeyword.Clear();
        }
    }
}
