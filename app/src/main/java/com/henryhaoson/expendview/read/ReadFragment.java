package com.henryhaoson.expendview.read;

import android.os.Bundle;

import com.henryhaoson.expendview.R;
import com.zhuhao.wordtextview.WordTextView;

import cn.henryzhuhao.mainframe.frame.base.BaseFragment;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class ReadFragment extends BaseFragment {
    private WordTextView textView;
    public static ReadFragment newInstance() {

        Bundle args = new Bundle();

        ReadFragment fragment = new ReadFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initView() {
        textView= view.findViewById(R.id.read_wordtextview);
        textView.setText("KIEV — The European Union warned Ukraine on Thursday time was running out to\n" +
                "revive shelved deals on free trade and political association by meeting the bloc's\n" +
                "concerns over the jailing of opposition leader Yulia Tymoshenko and bringing in\n" +
                "reforms.\n" +
                "A senior EU official also made it clear the agreements would fall through if Ukraine\n" +
                "面试作业\n" +
                "joined the Russia-led post-Soviet Customs Union trade bloc. \"We have a window of\n" +
                "opportunity. But time is short,'' Stefan Fuele, the European Commissioner for\n" +
                "Enlargement and European Neighbourhood Policy, said on a visit to Ukraine.\n" +
                "Brussels put off signing the landmark agreements after a Ukrainian court jailed former\n" +
                "prime minister Tymoshenko, President Viktor Yanukovich's main opponent, on an abuseof-office\n" +
                "charge in October 2011.\n" +
                "The EU says the Tymoshenko case and those of other prosecuted opposition politicians\n" +
                "are examples of selective justice and are a barrier to Ukraine's ambition of European\n" +
                "integration.\n" +
                "Two other issues raised by the bloc are related to the electoral system, which came\n" +
                "under fire from Western observers following the parliamentary election in October, and\n" +
                "legal reforms needed to bring Ukraine closer to EU standards.\n" +
                "\"The European Union is committed to signing the association agreement...provided\n" +
                "there is determined action and tangible progress on the three key issues: selective\n" +
                "justice, addressing the shortcomings of the October election and advancing the\n" +
                "association agenda reforms,'' Fuele told reporters. \"After several recent setbacks in\n" +
                "Ukraine there is a need to regain confidence that Ukraine could emerge as a modern\n" +
                "European country.''\n" +
                "Fuele, whose visit may set the tone of a Feb. 25 EU-Ukraine summit, said the two\n" +
                "agreements could be signed at the EU's Eastern Partnership summit in November if the\n" +
                "former Soviet republic met the bloc's conditions.\n" +
                "But he warned the Kiev government that joining a customs union with Russia,\n" +
                "aggressively promoted by Moscow, would ruin those prospects.\n" +
                "\"Joining any structure which would imply transferring the ability to set tariffs and define\n" +
                "its trade policy to a supranational body would mean that Ukraine would no longer be\n" +
                "able to implement the tariff dismantling agreed with the European Union in the context\n" +
                "of the DCFTA [Deep and Comprehensive Free Trade Agreement],'' Fuele said in a speech\n" +
                "at the Ukrainian parliament.\n" +
                "\"It would also not be able anymore to regulate areas such as food standards, or\n" +
                "technical product standards, all of them important in the framework of the DCFTA. It will\n" +
                "not be able to integrate economically with the European Union,\" he continued.\n" +
                "Ukrainian officials say they are committed to European integration. But they say they are\n" +
                "also looking for a way to cooperate with the Customs Union because both blocs are\n" +
                "Ukraine's major trade partners.\n" +
                "Fuele urged Ukraine to make sure it adopts and implements laws that actually work and\n" +
                "adhere to European standards, citing as an example the law on state procurement -\n" +
                "purchases of goods and services by the government.\n" +
                "The EU suspended some of its Ukraine financial aid programs after Kiev adopted a law\n" +
                "on state procurement which Brussels said was riddled with loopholes and thus failed to\n" +
                "ensure transparent and competitive procedures.");
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showLoadingContentView() {

    }

    @Override
    public void removeLoadingContentView() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public int getRootViewId() {
        return 0;
    }
}
