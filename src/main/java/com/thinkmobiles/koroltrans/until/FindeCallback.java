package com.thinkmobiles.koroltrans.until;

import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Oil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 15.10.15.
 */
public interface FindeCallback {
    void onTaskCompleted(List<Documents> documentses, List<Oil> oils );
}
