package com.github.lkapitman.filemanager.download;

/**
 * The interface Download listener.
 */
public interface DownloadListener {
    /**
     * On download job finished.
     *
     * @param job the job
     */
    public void onDownloadJobFinished(DownloadJob job);

    /**
     * On download job progress changed.
     *
     * @param job the job
     */
    public void onDownloadJobProgressChanged(DownloadJob job);
}
