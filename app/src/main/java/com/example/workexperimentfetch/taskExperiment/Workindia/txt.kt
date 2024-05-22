package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia

import com.google.gson.annotations.SerializedName

//The module have to fetch a list of experiments from the api. The experiment item is as follows:
//{
//    "experiment_name": "exp_1",
//    "is_enabled": true/false,
//    "experiment_value": ["value1", "value2", "value3"]
//}
//There is a limitation of number of calls to the api. Store the data for experiments locally. Maintain expiry of this cache to be 8 hours from the last fetch.
//Create an in memory cache to access the data of experiments on the main thread.
//The experiments should be accessible through a view





