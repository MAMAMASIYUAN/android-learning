class DownloadTask extends AsyncTask<Void, Integer, Boolean> {  
  
    @Override  
    protected void onPreExecute() {  
        progressDialog.show();  
    }  
  
    @Override  
    protected Boolean doInBackground(Void... params) {  
        try {  
            while (true) {  
                int downloadPercent = doDownload();  
                publishProgress(downloadPercent);  
                if (downloadPercent >= 100) {  
                    break;  
                }  
            }  
        } catch (Exception e) {  
            return false;  
        }  
        return true;  
    }  
  
    @Override  
    protected void onProgressUpdate(Integer... values) {  
        progressDialog.setMessage("当前下载进度：" + values[0] + "%");  
    }  
  
    @Override  
    protected void onPostExecute(Boolean result) {  
        progressDialog.dismiss();  
        if (result) {  
            Toast.makeText(context, "下载成功", Toast.LENGTH_SHORT).show();  
        } else {  
            Toast.makeText(context, "下载失败", Toast.LENGTH_SHORT).show();  
        }  
    }  
}

new DownloadTask().execute();  